package cc.duduhuo.multi.module.module2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("cc.duduhuo.multi.module")
class Module2Application

fun main(args: Array<String>) {
    runApplication<Module2Application>(*args)
}
