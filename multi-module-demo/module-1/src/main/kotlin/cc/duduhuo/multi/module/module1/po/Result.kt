package cc.duduhuo.multi.module.module1.po

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/11/18 16:32
 * Description:
 * Remarks:
 * =======================================================
 */
class Result<T>(
    var code: Int = 0,
    var msg: String = "",
    var data: T? = null
)