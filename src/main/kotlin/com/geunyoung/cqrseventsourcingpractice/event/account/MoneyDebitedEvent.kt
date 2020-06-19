package com.geunyoung.cqrseventsourcingpractice.event.account

import com.geunyoung.cqrseventsourcingpractice.event.BaseEvent


class MoneyDebitedEvent(id: String, val debitAmount: Double, val currency: String) : BaseEvent<String>(id)