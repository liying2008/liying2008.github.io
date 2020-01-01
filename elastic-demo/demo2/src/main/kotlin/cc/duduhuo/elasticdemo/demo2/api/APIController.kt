package cc.duduhuo.elasticdemo.demo2.api

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/1/1 20:15
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("/api")
class APIController(private val apiService: APIService) {
    private val logger = LoggerFactory.getLogger(APIController::class.java)

    @PutMapping("/index")
    fun createIndex() {
        apiService.createIndex()
    }
}