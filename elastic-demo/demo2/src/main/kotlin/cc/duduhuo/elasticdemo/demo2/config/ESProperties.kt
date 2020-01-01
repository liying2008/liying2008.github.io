package cc.duduhuo.elasticdemo.demo2.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/1/1 19:24
 * Description:
 * Remarks:
 * =======================================================
 */
@Component
@ConfigurationProperties(prefix = "data.elasticsearch", ignoreUnknownFields = false, ignoreInvalidFields = false)
class ESProperties {
    /** Rest 配置 */
    var rest = Rest()

    class Rest {
        /** ES uris */
        var uris = listOf<String>()
        /** 用户名 */
        var username = ""
        /** 密码 */
        var password = ""
        /** 连接超时 */
        var connectionTimeout = 2000
        var socketTimeout = 2000
        var connectionRequestTimeout = 1000
        var maxConnPerRoute = 10
        var maxConnTotal = 30
    }
}