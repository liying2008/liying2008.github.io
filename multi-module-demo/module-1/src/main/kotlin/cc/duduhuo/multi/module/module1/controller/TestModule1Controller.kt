package cc.duduhuo.multi.module.module1.controller

import cc.duduhuo.multi.module.module1.anno.RestRequestMapping
import cc.duduhuo.multi.module.module1.cache.CacheApiType
import cc.duduhuo.multi.module.module1.cache.annotation.CacheApi
import cc.duduhuo.multi.module.module1.cache.annotation.InputParam
import cc.duduhuo.multi.module.module1.po.Enc
import cc.duduhuo.multi.module.module1.util.EncUtils
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/11/15 23:02
 * Description:
 * Remarks:
 * =======================================================
 */
@RestRequestMapping("/m1")
class TestModule1Controller {

    @GetMapping
    fun sayHello(): Enc<String> {
        return EncUtils.success("Hello Module-1")
    }

    @CacheApi(description = "刷新测试缓存", type = CacheApiType.REFRESH)
    @PutMapping("/cache")
    fun refreshCache(): Enc<Unit> {
        println("refreshCache...")
        return EncUtils.success(null)
    }

    @CacheApi(description = "删除测试缓存", type = CacheApiType.DELETE, inputParams = [
        InputParam("缓存ID", true, "缓存ID")
    ])
    @DeleteMapping("/cache")
    fun deleteCache(id: String): Enc<Unit> {
        println("deleteCache...")
        return EncUtils.success(null)
    }
}
