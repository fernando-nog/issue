package io.micronaut.data.issue.controller

import io.micronaut.data.issue.model.Customer
import io.micronaut.data.issue.model.CustomerDetails
import io.micronaut.data.issue.repository.CustomerReposiroty
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/issue")
class CustomerController(
    val customerReposiroty: CustomerReposiroty
) {

    @Get("problem")
    suspend fun findWithProblem(){
        val customer = Customer(1L)
        customerReposiroty.findByCustomerAndCategoryActive(customer, true)
    }

    @Get("ok")
    suspend fun findOk(): HttpResponse<List<CustomerDetails>?> {
        val customer = Customer(1L)
        return HttpResponse.ok(customerReposiroty.findByCustomer(customer))
    }
}