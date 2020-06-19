package com.geunyoung.cqrseventsourcingpractice.entity

import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class AccountQueryEntity(
        @Id
        var id: String? = null,
        var accountBalance: Double,
        var currency: String,
        var status: String
) {
    override fun toString(): String {
        return "AccountQueryEntity{" +
                "id='" + id + '\''.toString() +
                ", accountBalance=" + accountBalance +
                ", currency='" + currency + '\''.toString() +
                ", status='" + status + '\''.toString() +
                '}'.toString()
    }
}