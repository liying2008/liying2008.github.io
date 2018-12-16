package cc.duduhuo.multi.module.module1.controller

import cc.duduhuo.multi.module.module1.po.Enc
import cc.duduhuo.multi.module.module1.util.EncUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/11/15 23:02
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("/m1")
class TestModule1Controller {

    @GetMapping
    fun sayHello(): Enc<String> {
        return EncUtils.success("Hello Module-1")
    }
}