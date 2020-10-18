package cc.duduhuo.multi.module.module1.cache

import cc.duduhuo.multi.module.module1.po.Enc
import cc.duduhuo.multi.module.module1.util.EncUtils
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import java.lang.reflect.Method

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/10/18 12:59
 * Description:
 * Remarks:
 * =======================================================
 */
@RestController
@RequestMapping("/cacheApis")
class CacheApiController {

    @Autowired
    private lateinit var requestMappingHandlerMapping: RequestMappingHandlerMapping

    @GetMapping
    fun findAllCacheApis(): Enc<List<CacheApi>> {
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
        val reflections = Reflections("", MethodAnnotationsScanner())
        val methods = reflections.getMethodsAnnotatedWith(cc.duduhuo.multi.module.module1.cache.annotation.CacheApi::class.java)
        val cacheApis = mutableListOf<cc.duduhuo.multi.module.module1.cache.CacheApi>()
        methods.forEach { method ->
            println(method)
            if (method !in apiMap) return@forEach
            val apiInfo = apiMap[method]!!
            if (apiInfo.first == null || apiInfo.second == null) return@forEach

            val methodCacheApi = method.getDeclaredAnnotation(cc.duduhuo.multi.module.module1.cache.annotation.CacheApi::class.java)
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
//        cacheApis.forEach { println(it) }

        return EncUtils.success(cacheApis)
    }
}
