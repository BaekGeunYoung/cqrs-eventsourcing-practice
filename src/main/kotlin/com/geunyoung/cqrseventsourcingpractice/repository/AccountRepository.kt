package com.geunyoung.cqrseventsourcingpractice.repository

import com.geunyoung.cqrseventsourcingpractice.domain.entity.AccountQueryEntity
import org.springframework.data.repository.CrudRepository


interface AccountRepository : CrudRepository<AccountQueryEntity, String>