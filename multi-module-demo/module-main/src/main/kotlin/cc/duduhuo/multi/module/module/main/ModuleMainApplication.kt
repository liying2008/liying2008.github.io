package cc.duduhuo.multi.module.module.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("cc.duduhuo.multi.module")
class ModuleMainApplication

fun main(args: Array<String>) {
    runApplication<ModuleMainApplication>(*args)
}
