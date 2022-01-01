package com.ex.jm

import org.apache.camel.Exchange
import org.apache.camel.builder.RouteBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
class RouteConfiguration {
    @Bean
    @Profile("!test")
    fun defaultRouteBuilder(): RouteBuilder {
        return object : RouteBuilder() {
            override fun configure() {
                rest("health-job").consumes("application/json").post()
                    .route().routeId("health_job").process("jmProcessor")
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, simple("200"))
            }
        }
    }
}