package com.geunyoung.cqrseventsourcingpractice.event.account

import com.geunyoung.cqrseventsourcingpractice.event.BaseEvent


class AccountHeldEvent(override val id: String, val status: String) : BaseEvent<String>(id)