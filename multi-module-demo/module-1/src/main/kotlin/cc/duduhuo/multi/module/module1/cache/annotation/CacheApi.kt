package cc.duduhuo.multi.module.module1.cache.annotation

import cc.duduhuo.multi.module.module1.cache.CacheApiType

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/10/18 12:32
 * Description:
 * Remarks:
 * =======================================================
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class CacheApi(
    val description: String,
    val type: CacheApiType,
    val inputParams: Array<InputParam> = []
)

@MustBeDocumented
annotation class InputParam(
    val name: String,
    val required: Boolean,
    val description: String
)
