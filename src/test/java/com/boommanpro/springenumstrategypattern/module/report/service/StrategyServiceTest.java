package com.boommanpro.springenumstrategypattern.module.report.service;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述
 * Created by Y.S.K on 2020/5/5 0:33
 */
@Component
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StrategyServiceTest {
    @Autowired
    private GeneratorContextService generatorContextService;

    @Test
    public void testGeneratorReport() {
        generatorContextService.generatorContext("123", ProcessType.QUERY_PROCESS);
        generatorContextService.generatorContext("456", ProcessType.FOCUS_PROCESS);
    }
}