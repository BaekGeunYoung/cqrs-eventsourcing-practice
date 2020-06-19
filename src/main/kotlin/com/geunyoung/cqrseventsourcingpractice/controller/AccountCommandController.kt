package com.geunyoung.cqrseventsourcingpractice.controller

import com.geunyoung.cqrseventsourcingpractice.dto.AccountCreateDto
import com.geunyoung.cqrseventsourcingpractice.dto.MoneyCreditDto
import com.geunyoung.cqrseventsourcingpractice.dto.MoneyDebitDto
import com.geunyoung.cqrseventsourcingpractice.service.AccountCommandService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/bank-accounts")
class AccountCommandController(
        @Autowired private val accountCommandService: AccountCommandService
) {
    @PostMapping("/")
    fun createAccount(@RequestBody accountCreateDto: AccountCreateDto): CompletableFuture<String> {
        return accountCommandService.createAccount(accountCreateDto)
    }

    @PutMapping("/credits/{accountNumber}")
    fun creditMoneyToAccount(
            @PathVariable("accountNumber") accountNumber: String,
            @RequestBody moneyCreditDto: MoneyCreditDto
    ): CompletableFuture<String> {
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDto)
    }

    @PutMapping("/debits/{accountNumber}")
    fun debitMoneyFromAccount(
            @PathVariable("accountNumber") accountNumber: String,
            @RequestBody moneyDebitDto: MoneyDebitDto
    ): CompletableFuture<String> {
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDto)
    }
}