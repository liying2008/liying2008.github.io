package cc.duduhuo.multi.module.module1.util

import cc.duduhuo.multi.module.module1.po.Enc

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/16 17:55
 * Description:
 * Remarks:
 * =======================================================
 */
object EncUtils {
    fun <T> success(data: T?): Enc<T> {
        return Enc(0, "success", data)
    }
}