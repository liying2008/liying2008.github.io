package cc.duduhuo.elasticdemo.demo2.config

import org.apache.http.HttpHost
import org.apache.http.auth.AuthScope
import org.apache.http.auth.UsernamePasswordCredentials
import org.apache.http.client.config.RequestConfig
import org.apache.http.impl.client.BasicCredentialsProvider
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestClientBuilder
import org.elasticsearch.client.RestHighLevelClient
import java.io.IOException


/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/1/1 18:27
 * Description:
 * Remarks:
 * =======================================================
 */
class ESClientFactory private constructor() {
    companion object {
        private var username = ""
        private var password = ""
        private var connectTimeoutMillis = 1000
        private var socketTimeoutMillis = 30000
        private var connectionRequestTimeoutMillis = 500
        private var maxConnPerRoute = 10
        private var maxConnTotal = 30

        private var httpHosts: Array<HttpHost> = arrayOf()

        private val esClientFactory: ESClientFactory = ESClientFactory()

        fun build(httpHosts: Array<HttpHost>, username: String, password: String, connectTimeout: Int, socketTimeout: Int,
                  connectionRequestTimeout: Int, maxConnTotal: Int, maxConnPerRoute: Int): ESClientFactory {
            this.httpHosts = httpHosts
            this.username = username
            this.password = password
            this.connectTimeoutMillis = connectTimeout
            this.socketTimeoutMillis = socketTimeout
            this.connectionRequestTimeoutMillis = connectionRequestTimeout
            this.maxConnTotal = maxConnTotal
            this.maxConnPerRoute = maxConnPerRoute
            return esClientFactory
        }
    }

    private var builder: RestClientBuilder? = null
    private var restClient: RestClient? = null
    private var restHighLevelClient: RestHighLevelClient? = null

    fun init() {
        builder = RestClient.builder(*httpHosts)
        setConnectTimeoutConfig()
        setMultiConnectConfig()
        restClient = builder!!.build()
        restHighLevelClient = RestHighLevelClient(builder)
        println("init factory")
    }

    // 配置连接时间延时
    private fun setConnectTimeoutConfig() {
        builder!!.setRequestConfigCallback { requestConfigBuilder: RequestConfig.Builder ->
            requestConfigBuilder.setConnectTimeout(connectTimeoutMillis)
            requestConfigBuilder.setSocketTimeout(socketTimeoutMillis)
            requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeoutMillis)
            requestConfigBuilder
        }
    }

    // 使用异步httpclient时设置并发连接数 和 认证
    private fun setMultiConnectConfig() {
        builder!!.setHttpClientConfigCallback { httpClientBuilder: HttpAsyncClientBuilder ->
            httpClientBuilder.setMaxConnTotal(maxConnTotal)
            httpClientBuilder.setMaxConnPerRoute(maxConnPerRoute)
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val provider = BasicCredentialsProvider()
                provider.setCredentials(AuthScope.ANY, UsernamePasswordCredentials(username, password))
                httpClientBuilder.setDefaultCredentialsProvider(provider)
            }
            httpClientBuilder
        }
    }

    fun getClient(): RestClient {
        return restClient!!
    }

    fun getRhlClient(): RestHighLevelClient {
        return restHighLevelClient!!
    }

    fun close() {
        try {
            restClient?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        println("close client")
    }
}