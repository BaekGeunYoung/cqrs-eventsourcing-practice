package com.geunyoung.cqrseventsourcingpractice.service.impl

import com.geunyoung.cqrseventsourcingpractice.service.AccountQueryService
import org.axonframework.eventsourcing.eventstore.EventStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AccountQueryServiceImpl(
        @Autowired private val eventStore: EventStore
): AccountQueryService {
    override fun listEventsForAccount(accountNumber: String): List<Any> {
        return eventStore.readEvents(accountNumber).asStream().map { s -> s.payload }.collect(Collectors.toList())
    }
}