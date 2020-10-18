package cc.duduhuo.multi.module.module1.cache

import org.springframework.web.bind.annotation.RequestMethod

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/10/18 12:42
 * Description:
 * Remarks:
 * =======================================================
 */
data class CacheApi(
    val path: String,
    val description: String,
    val type: CacheApiType,
    val requestMethod: RequestMethod,
    val inputParam: InputParam? = null
)

data class InputParam(
    val name: String,
    val required: Boolean,
    val description: String
)
