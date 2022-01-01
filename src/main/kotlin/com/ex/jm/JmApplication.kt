package com.ex.jm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy


@SpringBootApplication(exclude = [JpaRepositoriesAutoConfiguration::class, DataSourceAutoConfiguration::class])
@EnableAspectJAutoProxy
class JmApplication

fun main(args: Array<String>) {
	runApplication<JmApplication>(*args)
}
