package com.geunyoung.cqrseventsourcingpractice.event

open class BaseEvent<T> (
        open val id: T
)