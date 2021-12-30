package rcar.samples.springbootmvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringbootMvcApplication

fun main(args: Array<String>) {
	runApplication<SpringbootMvcApplication>(*args)
}
