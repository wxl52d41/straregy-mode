package com.boommanpro.springenumstrategypattern.module.report.enums;

import java.lang.annotation.*;

/**
 * @author
 * @date 2020/5/4 18:28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ProcessTypeEnumFlag {

    ProcessType value();
}
