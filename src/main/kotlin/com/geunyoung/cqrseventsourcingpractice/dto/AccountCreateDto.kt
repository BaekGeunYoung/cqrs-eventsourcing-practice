package com.geunyoung.cqrseventsourcingpractice.dto

data class AccountCreateDto(
        var startingBalance: Double,
        var currency: String
)