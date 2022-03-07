package io.micronaut.data.issue.model

import io.micronaut.data.annotation.*
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.model.naming.NamingStrategies
import java.time.LocalDateTime

@MappedEntity(namingStrategy = NamingStrategies.Raw::class)
data class CustomerDetails (

        @field:Id @GeneratedValue
        var id: Long? = null,

        @Relation(value = Relation.Kind.ONE_TO_ONE)
        @MappedProperty("customerId")
        var customer: Customer? = null,

        @Relation(value = Relation.Kind.ONE_TO_ONE)
        @MappedProperty("categoryId")
        var category: Category? = null,

        var label: String? = null,
        var detail: String? = null,

        @field:DateCreated
        var createdAt: LocalDateTime? = null,

        @field:DateUpdated
        var updatedAt: LocalDateTime? = null
)


@MappedEntity(namingStrategy = NamingStrategies.Raw::class)
data class Category (

        @field:Id @GeneratedValue
        var id: Long? = null,
        var name: String? = null,

        var active: Boolean? = null,

        @field:DateCreated
        var createdAt: LocalDateTime? = null,

        var priority: Long? = null

)

@MappedEntity(namingStrategy = NamingStrategies.Raw::class)
data class Customer(

        @field:Id @GeneratedValue
        var id: Long? = null,
        var name: String = "",

        @field:DateCreated
        var createdAt: LocalDateTime? = null,

        var showCustomer: Boolean? = false

)



