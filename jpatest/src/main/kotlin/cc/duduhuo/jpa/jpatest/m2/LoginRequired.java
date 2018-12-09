package cc.duduhuo.jpa.jpatest.m2;

import java.lang.annotation.*;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/9 17:57
 * Description:
 * Remarks:
 * =======================================================
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired {
}
