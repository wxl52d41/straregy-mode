package com.boommanpro.springenumstrategypattern.module.report.service;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;

/**
 * @author
 * @date 2020/5/4 18:08
 */
public interface GeneratorContextService {
    void generatorContext(String dataId, ProcessType type);
}
