package cc.duduhuo.multi.module.module1.anno;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2020/10/18 18:23
 * Description:
 * Remarks:
 * =======================================================
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping
public @interface RestRequestMapping {
    String name() default "";

    @AliasFor("path")
    String[] value() default {};

    @AliasFor("value")
    String[] path() default {};
}
