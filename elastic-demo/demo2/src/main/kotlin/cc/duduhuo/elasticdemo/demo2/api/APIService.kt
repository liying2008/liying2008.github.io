package cc.duduhuo.elasticdemo.demo2.api

import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.client.indices.CreateIndexRequest
import org.elasticsearch.client.indices.GetIndexRequest
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.xcontent.XContentType
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/1/1 19:57
 * Description:
 * Remarks:
 * =======================================================
 */
@Service
class APIService {
    private val logger = LoggerFactory.getLogger(APIService::class.java)
    private val indexName = "test-api-service"

    @Autowired
    private lateinit var rhlClient: RestHighLevelClient

    /**
     * 创建索引
     * 参考文档：
     * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.5/java-rest-high-create-index.html
     */
    fun createIndex() {
        val getIndexRequest = GetIndexRequest(indexName)
        val exists = rhlClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT)
        logger.info("exists={}", exists)
        if (!exists) {
            val createIndexRequest = CreateIndexRequest(indexName)
            createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
            )
            val mappingFile = ResourceUtils.getFile("classpath:es/log_mapping.json")
            createIndexRequest.mapping(mappingFile.readText(), XContentType.JSON)
            val createIndexResponse = rhlClient.indices().create(createIndexRequest, RequestOptions.DEFAULT)
            logger.info("acknowledged={}, shardsAcknowledged={}", createIndexResponse.isAcknowledged, createIndexResponse.isShardsAcknowledged)
        }
    }
}