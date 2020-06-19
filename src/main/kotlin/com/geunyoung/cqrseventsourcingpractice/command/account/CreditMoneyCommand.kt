package com.geunyoung.cqrseventsourcingpractice.command.account

import com.geunyoung.cqrseventsourcingpractice.command.BaseCommand


class CreditMoneyCommand(id: String, val creditAmount: Double, val currency: String) : BaseCommand<String>(id)