package cc.duduhuo.jpa.jpatest.m1

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/8 18:20
 * Description:
 * Remarks:
 * =======================================================
 */
@Service
@Transactional
class ModuleServiceImpl(private val mModuleRepository: ModuleRepository) : ModuleService {
    private val logger = LoggerFactory.getLogger(ModuleServiceImpl::class.java)

    override fun findModulesByM1(m1: String): List<Module> {
        return mModuleRepository.findModulesByM1ForQ(m1)
    }

//    override fun findModulesByOtherOtherId(oid: Long): List<Module> {
//        return mModuleRepository.findModulesByOther_OtherIdForQ(oid)
//    }

    override fun findModuleWithOthersByM1(m1: String): List<ModuleWithOther> {
        val mapper = ObjectMapper()
        val moduleWithOthers = mModuleRepository.findModuleWithOthersByM1(m1)
        logger.info(mapper.writeValueAsString(moduleWithOthers))
        return moduleWithOthers
    }

}