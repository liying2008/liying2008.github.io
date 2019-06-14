package cc.duduhuo.multi.module.module.main.service

import cc.duduhuo.multi.module.module.main.entity.SubClassA
import cc.duduhuo.multi.module.module.main.entity.SubClassB
import cc.duduhuo.multi.module.module.main.entity.SuperClass
import org.springframework.stereotype.Service

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2019/6/13 22:55
 * Description:
 * Remarks:
 * =======================================================
 */
@Service
class MultiSubTestService {

    fun getSubClass(type: Int): SuperClass {
        val c = when (type) {
            0 -> SubClassA(190)
            1 -> SubClassB(89)
            else -> SuperClass("100", "Unknown", 0)
        }
        c.extra = "aha"
        return c
    }
}