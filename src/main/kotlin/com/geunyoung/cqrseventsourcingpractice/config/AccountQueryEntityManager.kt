package com.geunyoung.cqrseventsourcingpractice.config

import com.geunyoung.cqrseventsourcingpractice.domain.aggregate.AccountAggregate
import com.geunyoung.cqrseventsourcingpractice.domain.entity.AccountQueryEntity
import com.geunyoung.cqrseventsourcingpractice.event.BaseEvent
import com.geunyoung.cqrseventsourcingpractice.repository.AccountRepository
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.eventsourcing.EventSourcingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class AccountQueryEntityManager (
        @Autowired
        private val accountRepository: AccountRepository,
        @Autowired
        @Qualifier("accountAggregateEventSourcingRepository")
        private val accountAggregateEventSourcingRepository: EventSourcingRepository<AccountAggregate>
) {
    @EventSourcingHandler
    fun on(event: BaseEvent<String>) {
        persistAccount(buildQueryAccount(getAccountFromEvent(event)))
    }

    private fun getAccountFromEvent(event: BaseEvent<String>): AccountAggregate {
        return accountAggregateEventSourcingRepository.load(event.id).wrappedAggregate.aggregateRoot
    }

    private fun findExistingOrCreateQueryAccount(id: String): AccountQueryEntity {
        return if(accountRepository.findById(id).isPresent) accountRepository.findById(id).get()
        else AccountQueryEntity()
    }

    private fun buildQueryAccount(accountAggregate: AccountAggregate): AccountQueryEntity {
        val accountQueryEntity = findExistingOrCreateQueryAccount(accountAggregate.id)

        accountQueryEntity.id = accountAggregate.id
        accountQueryEntity.accountBalance = accountAggregate.accountBalance
        accountQueryEntity.currency = accountAggregate.currency
        accountQueryEntity.status = accountAggregate.status

        return accountQueryEntity
    }

    private fun persistAccount(accountQueryEntity: AccountQueryEntity) {
        accountRepository.save(accountQueryEntity)
    }
}