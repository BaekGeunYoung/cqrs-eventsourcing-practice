package com.geunyoung.cqrseventsourcingpractice.event.account

import com.geunyoung.cqrseventsourcingpractice.event.BaseEvent


class AccountCreatedEvent(override val id: String, val accountBalance: Double, val currency: String) : BaseEvent<String>(id)