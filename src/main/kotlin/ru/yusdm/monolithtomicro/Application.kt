package ru.yusdm.monolithtomicro

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.yusdm.monolithtomicro.common.asString
import java.time.LocalDateTime

@SpringBootApplication
class Application: CommandLineRunner {

	override fun run(vararg args: String) {
		println("Common dateTimeUtils in action: " + LocalDateTime.now().asString());
	}

}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
