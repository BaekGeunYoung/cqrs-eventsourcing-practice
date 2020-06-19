package com.geunyoung.cqrseventsourcingpractice.command.account

import com.geunyoung.cqrseventsourcingpractice.command.BaseCommand


class DebitMoneyCommand(id: String, val debitAmount: Double, val currency: String) : BaseCommand<String>(id)