package cc.duduhuo.jpa.jpatest.m2

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/9 18:13
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("aop")
class AopController {

    @GetMapping("login")
    @LoginRequired
    fun testLogin(): String {
        return "ok"
    }

    @GetMapping("user")
    fun testUser(@CurrentUser user: String): String {
        return "ok"
    }

    @GetMapping("log")
    @OpLog
    fun testLog(): String {
        return "ok"
    }
}