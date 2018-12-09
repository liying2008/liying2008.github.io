package cc.duduhuo.jpa.jpatest.m2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
@Order(102)
public class OpLogAspect {
    private final Logger logger = LoggerFactory.getLogger(OpLogAspect.class);

    @Pointcut("@annotation(OpLog)")
    public void opLog() {
    }

    @AfterReturning("opLog()")
    public void recordOpLog(JoinPoint joinPoint) {
        logger.info("===recordOpLog===");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Annotation[] annotations = method.getDeclaredAnnotations();
        if (annotations != null) {
            parseAnnotation(annotations);
        }
    }

    private static List<String> annotationList = new ArrayList<>();

    private void parseAnnotation(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            String annotationString = annotation.toString();
            if (!annotationList.contains(annotationString)) {
                annotationList.add(annotationString);
                logger.info(annotationString);
                Annotation[] newAnnotations = annotation.annotationType().getAnnotations();
                parseAnnotation(newAnnotations);
            }
        }
    }
}
