package com.geunyoung.cqrseventsourcingpractice.event.account

import com.geunyoung.cqrseventsourcingpractice.event.BaseEvent


class AccountHeldEvent(id: String, val status: String) : BaseEvent<String>(id)