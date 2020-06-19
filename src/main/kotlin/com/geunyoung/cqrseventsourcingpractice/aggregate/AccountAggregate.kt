package com.geunyoung.cqrseventsourcingpractice.aggregate

import com.geunyoung.cqrseventsourcingpractice.command.account.CreateAccountCommand
import com.geunyoung.cqrseventsourcingpractice.command.account.CreditMoneyCommand
import com.geunyoung.cqrseventsourcingpractice.event.account.AccountActivatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.spring.stereotype.Aggregate
import com.geunyoung.cqrseventsourcingpractice.event.account.AccountCreatedEvent
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateLifecycle
import com.geunyoung.cqrseventsourcingpractice.event.account.MoneyCreditedEvent
import com.geunyoung.cqrseventsourcingpractice.event.account.AccountHeldEvent
import com.geunyoung.cqrseventsourcingpractice.event.account.MoneyDebitedEvent
import com.geunyoung.cqrseventsourcingpractice.command.account.DebitMoneyCommand




@Aggregate
class AccountAggregate {
    @AggregateIdentifier
    var id: String = ""

    var accountBalance: Double = 0.0

    var currency: String = ""

    var status: String = ""

    @CommandHandler
    fun on(createAccountCommand: CreateAccountCommand) {
        AggregateLifecycle.apply(AccountCreatedEvent(createAccountCommand.id, createAccountCommand.accountBalance, createAccountCommand.currency))
    }

    @EventSourcingHandler
    fun on(accountCreatedEvent: AccountCreatedEvent) {
        this.id = accountCreatedEvent.id
        this.accountBalance = accountCreatedEvent.accountBalance
        this.currency = accountCreatedEvent.currency
        this.status = "CREATED"

        AggregateLifecycle.apply(AccountActivatedEvent(this.id, "ACTIVATED"))
    }

    @EventSourcingHandler
    fun on(accountActivatedEvent: AccountActivatedEvent) {
        this.status = accountActivatedEvent.status
    }

    @CommandHandler
    fun on(creditMoneyCommand: CreditMoneyCommand) {
        AggregateLifecycle.apply(MoneyCreditedEvent(creditMoneyCommand.id, creditMoneyCommand.creditAmount, creditMoneyCommand.currency))
    }

    @EventSourcingHandler
    fun on(moneyCreditedEvent: MoneyCreditedEvent) {
        if (this.accountBalance < 0 && (this.accountBalance + moneyCreditedEvent.creditAmount) >= 0) {
            AggregateLifecycle.apply(AccountActivatedEvent(this.id, "ACTIVATED"))
        }

        this.accountBalance += moneyCreditedEvent.creditAmount
    }

    @CommandHandler
    fun on(debitMoneyCommand: DebitMoneyCommand) {
        AggregateLifecycle.apply(MoneyDebitedEvent(debitMoneyCommand.id, debitMoneyCommand.debitAmount, debitMoneyCommand.currency))
    }

    @EventSourcingHandler
    fun on(moneyDebitedEvent: MoneyDebitedEvent) {
        if ((this.accountBalance >= 0) and (this.accountBalance - moneyDebitedEvent.debitAmount < 0)) {
            AggregateLifecycle.apply(AccountHeldEvent(this.id, "HOLD"))
        }

        this.accountBalance -= moneyDebitedEvent.debitAmount
    }

    @EventSourcingHandler
    fun on(accountHeldEvent: AccountHeldEvent) {
        this.status = accountHeldEvent.status
    }
}