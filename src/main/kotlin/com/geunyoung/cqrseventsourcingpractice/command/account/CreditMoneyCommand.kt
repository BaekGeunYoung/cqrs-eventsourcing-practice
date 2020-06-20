package com.geunyoung.cqrseventsourcingpractice.command.account

import com.geunyoung.cqrseventsourcingpractice.command.BaseCommand
import org.axonframework.modelling.command.TargetAggregateIdentifier


class CreditMoneyCommand(@TargetAggregateIdentifier override val id: String, val creditAmount: Double, val currency: String) : BaseCommand<String>(id)