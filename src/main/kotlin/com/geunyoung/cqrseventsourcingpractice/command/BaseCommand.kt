package com.geunyoung.cqrseventsourcingpractice.command

import org.axonframework.modelling.command.TargetAggregateIdentifier

open class BaseCommand<T> (
        @TargetAggregateIdentifier
        open val id: T
)