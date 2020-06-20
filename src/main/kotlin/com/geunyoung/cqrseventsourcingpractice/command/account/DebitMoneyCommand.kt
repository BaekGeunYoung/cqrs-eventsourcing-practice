package com.geunyoung.cqrseventsourcingpractice.command.account

import com.geunyoung.cqrseventsourcingpractice.command.BaseCommand
import org.axonframework.modelling.command.TargetAggregateIdentifier


class DebitMoneyCommand(@TargetAggregateIdentifier override val id: String, val debitAmount: Double, val currency: String) : BaseCommand<String>(id)