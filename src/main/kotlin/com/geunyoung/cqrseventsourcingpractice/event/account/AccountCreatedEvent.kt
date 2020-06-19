package com.geunyoung.cqrseventsourcingpractice.event.account

import com.geunyoung.cqrseventsourcingpractice.event.BaseEvent


class AccountCreatedEvent(id: String, val accountBalance: Double, val currency: String) : BaseEvent<String>(id)