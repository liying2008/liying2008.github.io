package cc.duduhuo.jpa.jpatest.m2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/9 18:05
 * Description:
 * Remarks:
 * =======================================================
 */
@Aspect
@Component
@Order(101)
public class CurrentUserAspect {
    private final Logger logger = LoggerFactory.getLogger(CurrentUserAspect.class);

    @Pointcut("execution(* *(..,@CurrentUser (*),..))")
    public void currentUser() {
    }


    @Around("currentUser()")
    public Object injectCurrentUser(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("===injectCurrentUser===");
        return pjp.proceed(new Object[]{"1"});
    }
}
