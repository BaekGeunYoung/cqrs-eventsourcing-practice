package com.geunyoung.cqrseventsourcingpractice.event.account

import com.geunyoung.cqrseventsourcingpractice.event.BaseEvent


class MoneyCreditedEvent(id: String, val creditAmount: Double, val currency: String) : BaseEvent<String>(id)