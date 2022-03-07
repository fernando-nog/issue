package io.micronaut.data.issue

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("io.micronaut.data.issue")
		.start()
}

