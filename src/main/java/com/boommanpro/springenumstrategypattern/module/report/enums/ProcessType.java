package com.boommanpro.springenumstrategypattern.module.report.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author
 * @date 2020/5/4 18:07
 */
@Slf4j
@Getter
public enum ProcessType  {
    /**
     * 查询报告
     */
    QUERY_PROCESS("查询流程", "查询流程报告描述"),

    /**
     * 关注报告
     */
    FOCUS_PROCESS("关注流程", "关注流程报告描述");

    private final String name;

    private final String desc;

    ProcessType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

}
