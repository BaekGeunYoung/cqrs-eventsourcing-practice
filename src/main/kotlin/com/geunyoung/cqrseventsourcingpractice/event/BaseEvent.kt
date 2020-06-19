package com.geunyoung.cqrseventsourcingpractice.event

open class BaseEvent<T> (
        var id: T
)