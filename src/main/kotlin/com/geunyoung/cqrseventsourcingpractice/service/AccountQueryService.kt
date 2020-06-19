package com.geunyoung.cqrseventsourcingpractice.service

interface AccountQueryService {
    fun listEventsForAccount(accountNumber: String): List<Any>
}