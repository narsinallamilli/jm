package com.ex.jm

import org.apache.camel.CamelContext
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author Narsi Nallamilli
 * @since 01 April 2020
 */
abstract class CommonService : Service {
    @Autowired
    lateinit var camelContext: CamelContext
}