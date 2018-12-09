package cc.duduhuo.jpa.jpatest.m1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/8 18:23
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("module")
class ModuleController(private val mModuleService: ModuleService) {

    @GetMapping("/{m1}")
    fun findModulesByM1(@PathVariable("m1") m1: String): List<Module> {
        return mModuleService.findModulesByM1(m1)
    }

//    @GetMapping("/other/{oid}")
//    fun findModulesByOtherOtherId(@PathVariable("oid") oid: Long): List<Module> {
//        return mModuleService.findModulesByOtherOtherId(oid)
//    }

    @GetMapping("/mo/{m1}")
    fun findModuleWithOthersByM1(@PathVariable("m1") m1: String): List<ModuleWithOther> {
        return mModuleService.findModuleWithOthersByM1(m1)
    }
}