package com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.impl;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessTypeEnumFlag;
import com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 具体策略（ConcreteStrategy）：具体策略是实现策略接口的类。
 * 具体策略实现策略接口所定义的抽象方法，即给出算法标识的具体算法。
 */
@Slf4j
@Service
@ProcessTypeEnumFlag(ProcessType.FOCUS_PROCESS)//自定义注解，标注该类为FOCUS_PROCESS
public class FocusProcessStrategyService implements Strategy {

    @Override
    public void generatorReport(String dataId) {
        log.info("生成关注报告,报告Id:[{}]", dataId);
    }
}
