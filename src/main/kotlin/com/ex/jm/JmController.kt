package com.ex.jm

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class JmController {
    @Autowired
    lateinit var jmService: JmService

    @GetMapping("/hello")
    fun greeting(): String {
        println(jmService.camelContext.name)
        return "ok"
    }
}