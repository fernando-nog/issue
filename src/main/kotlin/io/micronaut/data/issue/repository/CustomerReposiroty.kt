package io.micronaut.data.issue.repository

import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.repeatable.JoinSpecifications
import io.micronaut.data.issue.model.Customer
import io.micronaut.data.issue.model.CustomerDetails
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository

@R2dbcRepository(dialect = Dialect.H2)
interface CustomerReposiroty : CoroutineCrudRepository<CustomerDetails, Long> {

    @JoinSpecifications( Join("customer"), Join("category") )
    suspend fun findByCustomerAndCategoryActive(customer: Customer, active:Boolean): List<CustomerDetails>?

    @JoinSpecifications( Join("customer"))
    suspend fun findByCustomer(customer: Customer): List<CustomerDetails>?
}