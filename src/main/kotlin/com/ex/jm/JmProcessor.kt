package com.ex.jm

import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.Instant

/**
 * Processor is triggered either by 'execution-job-scheduler' or 'execution-event-job-scheduler routeId of [RouteConfiguration.configure]
 *
 * Based on 'x-aws-sqsd-taskname' header value received from AWS rest request, this processor fetches all related
 * the records from 'x_job_configs' table and pushes them to '{env}_job_schedule.fifo queue. 'job_schedule_consumer' routeId
 * of [RouteConfiguration.jobScheduleConsumerRouteBuilder] will be consuming these messages from the queue.
 *
 * @author Narsi Nallamilli
 * @since 10 April 2020
 */
@Component
class JmProcessor : Processor {
    @Autowired
    lateinit var jmService: JmService

    @Throws(Exception::class)
    override fun process(exchange: Exchange) {
        val jobName = exchange.getIn().getHeader("x-aws-sqsd-taskname") as String
        System.out.println(jmService.camelContext)
        System.out.println("Health Check - " + Instant.now() + "-" + jobName)
    }
}