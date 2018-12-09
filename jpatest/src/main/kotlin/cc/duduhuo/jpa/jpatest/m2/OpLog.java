package cc.duduhuo.jpa.jpatest.m2;

import java.lang.annotation.*;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/9 18:04
 * Description:
 * Remarks:
 * =======================================================
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@LoginRequired
public @interface OpLog {
}
