package cc.duduhuo.jpa.jpatest.m1

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/8 18:20
 * Description:
 * Remarks:
 * =======================================================
 */
interface ModuleService {

    fun findModulesByM1(m1: String): List<Module>

//    fun findModulesByOtherOtherId(oid: Long): List<Module>

    fun findModuleWithOthersByM1(m1: String): List<ModuleWithOther>
}