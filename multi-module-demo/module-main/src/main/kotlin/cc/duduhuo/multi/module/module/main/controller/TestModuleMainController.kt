package cc.duduhuo.multi.module.module.main.controller

import cc.duduhuo.multi.module.module.main.entity.SuperClass
import cc.duduhuo.multi.module.module.main.service.MultiSubTestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
class TestModuleMainController(private val multiSubTestService: MultiSubTestService) {

    @GetMapping
    fun sayHello(): String {
        return "Hello Module Main"
    }

    /**
     * NOTE:
     * 实际返回的是实际类型（如SubClassA, SubClassB）
     */
    @GetMapping("/subclass/{type}")
    fun getSubClass(@PathVariable type: Int): SuperClass {
        return multiSubTestService.getSubClass(type)
    }
}