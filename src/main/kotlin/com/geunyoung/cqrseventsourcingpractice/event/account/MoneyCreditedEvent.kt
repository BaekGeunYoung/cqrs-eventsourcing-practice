package com.geunyoung.cqrseventsourcingpractice.event.account

import com.geunyoung.cqrseventsourcingpractice.event.BaseEvent


class MoneyCreditedEvent(override val id: String, val creditAmount: Double, val currency: String) : BaseEvent<String>(id)