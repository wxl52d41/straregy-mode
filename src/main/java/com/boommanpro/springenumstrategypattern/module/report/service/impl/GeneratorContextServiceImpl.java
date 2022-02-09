package com.boommanpro.springenumstrategypattern.module.report.service.impl;

import com.boommanpro.springenumstrategypattern.common.ProcessTypeGeneratorReportConfig;
import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import com.boommanpro.springenumstrategypattern.module.report.service.GeneratorContextService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 上下文（Context）：上下文是依赖于策略接口的类，即上下文包含有策略声明的变量。
 * 上下文中提供了一个方法，该方法委托策略变量调用具体策略所实现的策略接口中的方法。
 */
@Service
public class GeneratorContextServiceImpl implements GeneratorContextService {

    @Override
    public void generatorContext(String dataId, ProcessType type) {
        Optional.ofNullable(ProcessTypeGeneratorReportConfig.generatorStrategyMap.get(type))
                .orElseThrow(() -> new RuntimeException("没有找到实现的bean" + this))
                .generatorReport(dataId);
    }
}
