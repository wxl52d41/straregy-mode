package com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.impl;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessTypeEnumFlag;
import com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author
 * @date 2020/5/4 18:18
 */
@Slf4j
@Service
@ProcessTypeEnumFlag(ProcessType.QUERY_PROCESS)//自定义注解，标注该类为QUERY_PROCESS
public class QueryProcessStrategyService implements Strategy {

    @Override
    public void generatorReport(String dataId) {
        log.info("生成查询报告,报告Id:[{}]", dataId);
    }
}
