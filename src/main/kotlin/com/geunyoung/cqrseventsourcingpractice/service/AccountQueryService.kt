package com.geunyoung.cqrseventsourcingpractice.service

import com.geunyoung.cqrseventsourcingpractice.domain.entity.AccountQueryEntity

interface AccountQueryService {
    fun listEventsForAccount(accountNumber: String): List<Any>
    fun getAccount(accountNumber: String): AccountQueryEntity
}