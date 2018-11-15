package cc.duduhuo.multi.module.module3.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/11/15 23:07
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("/m3")
class TestModule3Controller {

    @GetMapping
    fun sayHello(): String {
        return "Hello Module3"
    }
}