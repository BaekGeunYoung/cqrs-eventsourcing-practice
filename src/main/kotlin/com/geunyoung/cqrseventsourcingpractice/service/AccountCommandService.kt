package com.geunyoung.cqrseventsourcingpractice.service

import com.geunyoung.cqrseventsourcingpractice.dto.AccountCreateDto
import com.geunyoung.cqrseventsourcingpractice.dto.MoneyCreditDto
import com.geunyoung.cqrseventsourcingpractice.dto.MoneyDebitDto
import java.util.concurrent.CompletableFuture

interface AccountCommandService {
    fun createAccount(accountCreateDto: AccountCreateDto): CompletableFuture<String>
    fun creditMoneyToAccount(accountNumber: String, moneyCreditDto: MoneyCreditDto): CompletableFuture<String>
    fun debitMoneyFromAccount(accountNumber: String, moneyDebitDto: MoneyDebitDto): CompletableFuture<String>
}