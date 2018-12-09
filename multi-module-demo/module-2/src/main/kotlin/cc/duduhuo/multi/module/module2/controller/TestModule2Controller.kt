package cc.duduhuo.multi.module.module2.controller

import cc.duduhuo.multi.module.module1.po.Result
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/11/15 23:05
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("/m2")
class TestModule2Controller {

    @GetMapping
    fun sayHello(): ResponseEntity<Result<String>> {
//        return ResponseEntity(Result(-1, "", "Hello Module2"), null, HttpStatus.NOT_FOUND)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Result(-1, "", "Hello Module2"))
    }
}