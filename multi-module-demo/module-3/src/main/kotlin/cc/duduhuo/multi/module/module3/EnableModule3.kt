package cc.duduhuo.multi.module.module3

import org.springframework.context.annotation.Import

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2019/6/13 22:26
 * Description:
 * Remarks:
 * =======================================================
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(Module3Application::class)
annotation class EnableModule3