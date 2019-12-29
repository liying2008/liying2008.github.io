package cc.duduhuo.elasticdemo.demo1.log

import org.springframework.data.domain.Page

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2019/12/29 20:40
 * Description:
 * Remarks:
 * =======================================================
 */
interface LogService {
    fun createIndex(): Boolean

    fun findByUserId(userId: String): Page<Log>

    fun findByUserAgentOsName(osName: String): Page<Log>

    fun save(log: Log): Log
}