package com.geunyoung.cqrseventsourcingpractice.command.account

import com.geunyoung.cqrseventsourcingpractice.command.BaseCommand
import org.axonframework.modelling.command.TargetAggregateIdentifier


class CreateAccountCommand(@TargetAggregateIdentifier override val id: String, val accountBalance: Double, val currency: String) : BaseCommand<String>(id)