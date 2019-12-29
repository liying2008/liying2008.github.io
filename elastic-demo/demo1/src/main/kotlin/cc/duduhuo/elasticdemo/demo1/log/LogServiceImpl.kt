package cc.duduhuo.elasticdemo.demo1.log

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate
import org.springframework.stereotype.Service

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2019/12/29 20:40
 * Description:
 * Remarks:
 * =======================================================
 */
@Service
class LogServiceImpl(private val logRepository: LogRepository) : LogService {
    private val logger = LoggerFactory.getLogger(LogServiceImpl::class.java)
    @Autowired
    private lateinit var elasticsearchRestTemplate: ElasticsearchRestTemplate

    override fun createIndex(): Boolean {
        return elasticsearchRestTemplate.createIndex(Log::class.java)
    }

    override fun findByUserId(userId: String): Page<Log> {
        val pageRequest = PageRequest.of(0, 10)
        return logRepository.findByUserId(userId, pageRequest)
    }

    override fun findByUserAgentOsName(osName: String): Page<Log> {
        val pageRequest = PageRequest.of(0, 10)
        return logRepository.findByUserAgent_OsName(osName, pageRequest)
    }

    override fun save(log: Log): Log {
        return logRepository.save(log)
    }
}