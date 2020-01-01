package cc.duduhuo.elasticdemo.demo2.config

import org.apache.http.HttpHost
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import java.net.URL


/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/1/1 19:22
 * Description:
 * Remarks:
 * =======================================================
 */
@Configuration
@ComponentScan(basePackageClasses = [ESClientFactory::class])
class ESConfig(esProperties: ESProperties) {

    private val restProperties = esProperties.rest

    @Bean
    fun httpHosts(): Array<HttpHost> {
        val uris = restProperties.uris
        return uris.map {
            val url = URL(it)
            val protocol = if (url.protocol.isNullOrEmpty()) "http" else url.protocol
            val host = url.host
            val port = if (url.port == -1) url.defaultPort else url.port
            HttpHost(host, port, protocol)
        }.toTypedArray()
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    fun getFactory(): ESClientFactory {
        return ESClientFactory.build(httpHosts(), restProperties.username, restProperties.password,
            restProperties.connectionTimeout, restProperties.socketTimeout, restProperties.connectionRequestTimeout,
            restProperties.maxConnTotal, restProperties.maxConnPerRoute)
    }

    @Bean
    @Scope("singleton")
    fun restClient(): RestClient {
        return getFactory().getClient()
    }

    @Bean
    @Scope("singleton")
    fun rhlClient(): RestHighLevelClient {
        return getFactory().getRhlClient()
    }
}