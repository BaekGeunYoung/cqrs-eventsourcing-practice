package com.geunyoung.cqrseventsourcingpractice.command.account

import com.geunyoung.cqrseventsourcingpractice.command.BaseCommand


class CreateAccountCommand(id: String, val accountBalance: Double, val currency: String) : BaseCommand<String>(id)