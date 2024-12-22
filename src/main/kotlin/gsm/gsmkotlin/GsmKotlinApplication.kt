package gsm.gsmkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class GsmKotlinApplication

fun main(args: Array<String>) {
    runApplication<GsmKotlinApplication>(*args)
}
