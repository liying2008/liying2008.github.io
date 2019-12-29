package cc.duduhuo.elasticdemo.demo1.log

import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2019/12/29 20:43
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("/log")
class LogController(private val logService: LogService) {
    private val logger = LoggerFactory.getLogger(LogController::class.java)

    @PutMapping("/index")
    fun createIndex(): Boolean {
        return logService.createIndex()
    }

    @GetMapping("/userId/{userId}")
    fun findByUserId(@PathVariable userId: String): Page<Log> {
        return logService.findByUserId(userId)
    }

    @GetMapping("/userAgent/osName/{osName}")
    fun findByUserAgentOsName(@PathVariable osName: String): Page<Log> {
        return logService.findByUserAgentOsName(osName)
    }

    @PutMapping
    fun save(@RequestBody log: Log): Log {
        return logService.save(log)
    }
}