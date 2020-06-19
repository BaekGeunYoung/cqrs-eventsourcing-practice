package com.geunyoung.cqrseventsourcingpractice.controller

import com.geunyoung.cqrseventsourcingpractice.service.AccountQueryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bank-accounts")
class AccountQueryController(
        @Autowired private val accountQueryService: AccountQueryService
) {
    @GetMapping("/{accountNumber}/events")
    fun listEventsForAccount(
            @PathVariable("accountNumber") accountNumber: String
    ): List<Any> {
        return accountQueryService.listEventsForAccount(accountNumber)
    }
}