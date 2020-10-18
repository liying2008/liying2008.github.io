package cc.duduhuo.multi.module.module1.cache

import cc.duduhuo.multi.module.module1.Module1Application
import cc.duduhuo.multi.module.module1.cache.annotation.CacheApi
import org.junit.jupiter.api.Test
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import java.lang.reflect.Method


/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/10/18 14:47
 * Description:
 * Remarks:
 * =======================================================
 */
@SpringBootTest(classes = [Module1Application::class])
@EnableAutoConfiguration
class ReflectionTest {
    private val logger = LoggerFactory.getLogger(ReflectionTest::class.java)

    @Autowired
    private lateinit var requestMappingHandlerMapping: RequestMappingHandlerMapping

    @Test
    fun test1() {
        val time1 = System.currentTimeMillis()

        val apiMap = mutableMapOf<Method, Pair<RequestMethod?, String?>>()

        val handlerMethods = requestMappingHandlerMapping.handlerMethods
        handlerMethods.forEach { (mappingInfo, handlerMethod) ->
            val patternsCondition = mappingInfo.patternsCondition
            val patterns = patternsCondition.patterns
            val methodsCondition = mappingInfo.methodsCondition
            val requestMethods = methodsCondition.methods
            val method = handlerMethod.method
            apiMap[method] = Pair(requestMethods.firstOrNull(), patterns.firstOrNull())
        }

        val packageName = "cc.duduhuo.multi.module.module1"
        val reflections = Reflections(packageName, MethodAnnotationsScanner())
        val methods = reflections.getMethodsAnnotatedWith(CacheApi::class.java)
        val cacheApis = mutableListOf<cc.duduhuo.multi.module.module1.cache.CacheApi>()
        methods.forEach { method ->
            println(method)
            if (method !in apiMap) return@forEach
            val apiInfo = apiMap[method]!!
            if (apiInfo.first == null || apiInfo.second == null) return@forEach

            val methodCacheApi = method.getDeclaredAnnotation(CacheApi::class.java)
            val description = methodCacheApi.description
            val type = methodCacheApi.type
            val inputParams = methodCacheApi.inputParams
            val inputParamAnno = if (inputParams.isEmpty()) {
                null
            } else {
                inputParams[0]
            }

            val inputParam = if (inputParamAnno == null) {
                null
            } else {
                InputParam(inputParamAnno.name, inputParamAnno.required, inputParamAnno.description)
            }
            val cacheApi = cc.duduhuo.multi.module.module1.cache.CacheApi(apiInfo.second!!, description, type, apiInfo.first!!, inputParam)
            cacheApis.add(cacheApi)
        }
        cacheApis.forEach { println(it) }
        println("time cost: ${System.currentTimeMillis() - time1}ms")
    }
}