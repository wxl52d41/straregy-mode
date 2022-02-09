package com.boommanpro.springenumstrategypattern.module.report.service.generatorreport;

/**
 * 策略（Strategy） 策略是一个接口，该接口定义算法标识。
 * @author
 * @date 2020/5/4 18:07
 */
public interface Strategy {

    /**
     * 根据dataId生成报告
     *
     * @param dataId 数据id
     */
    void generatorReport(String dataId);
}
