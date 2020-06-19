package com.geunyoung.cqrseventsourcingpractice.service.impl

import com.geunyoung.cqrseventsourcingpractice.command.account.CreateAccountCommand
import com.geunyoung.cqrseventsourcingpractice.command.account.CreditMoneyCommand
import com.geunyoung.cqrseventsourcingpractice.command.account.DebitMoneyCommand
import com.geunyoung.cqrseventsourcingpractice.dto.AccountCreateDto
import com.geunyoung.cqrseventsourcingpractice.dto.MoneyCreditDto
import com.geunyoung.cqrseventsourcingpractice.dto.MoneyDebitDto
import com.geunyoung.cqrseventsourcingpractice.service.AccountCommandService
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class AccountCommandServiceImpl(
        @Autowired private val commandGateway: CommandGateway
): AccountCommandService {
    override fun createAccount(accountCreateDto: AccountCreateDto): CompletableFuture<String> {
        return commandGateway.send(CreateAccountCommand(
                UUID.randomUUID().toString(),
                accountCreateDto.startingBalance,
                accountCreateDto.currency
        ))
    }

    override fun creditMoneyToAccount(accountNumber: String, moneyCreditDto: MoneyCreditDto): CompletableFuture<String> {
        return commandGateway.send(CreditMoneyCommand(
                accountNumber,
                moneyCreditDto.creditAmount,
                moneyCreditDto.currency
        ))
    }

    override fun debitMoneyFromAccount(accountNumber: String, moneyDebitDto: MoneyDebitDto): CompletableFuture<String> {
        return commandGateway.send(DebitMoneyCommand(
                accountNumber,
                moneyDebitDto.debitAmount,
                moneyDebitDto.currency
        ))
    }
}