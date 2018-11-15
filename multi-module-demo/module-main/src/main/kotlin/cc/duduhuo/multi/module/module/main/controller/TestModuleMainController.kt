package cc.duduhuo.multi.module.module.main.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/11/15 23:08
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("/")
class TestModuleMainController {

    @GetMapping
    fun sayHello(): String {
        return "Hello Module Main"
    }
}