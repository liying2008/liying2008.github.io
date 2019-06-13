package cc.duduhuo.multi.module.module.main

import cc.duduhuo.multi.module.module3.EnableModule3
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableModule3
class ModuleMainApplication

fun main(args: Array<String>) {
    runApplication<ModuleMainApplication>(*args)
}
