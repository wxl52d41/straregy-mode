package com.boommanpro.springenumstrategypattern.common;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author
 * @desc 将bean与注解进行映射的工具类
 * @date 2020/5/4 20:47
 */
public class EnumBeanMapUtil {

    /**
     * BeanMap2EnumMap
     *
     * @param beanMap        applicationContext.getBeansOfType();
     * @param annotationType annotation
     * @param function       current interface
     * @param <E>            Enum
     * @param <I>            ActionInterface
     * @param <A>            Annotation
     * @return
     */
    public static <E extends Enum<E>, I, A extends Annotation> Map<E, I> beanMap2EnumMap(Map<String, I> beanMap,
                                                                                         Class<A> annotationType,
                                                                                         Function<A, E> function) {
        Map<E, I> result = new HashMap<>();
        beanMap.forEach((s, bean) -> {
            A annotation = AnnotationUtils.findAnnotation(bean.getClass(), annotationType);
            if (annotation == null) {
                return;
            }
            E value = function.apply(annotation);
            result.put(value, bean);
        });
        return result;
    }
}
