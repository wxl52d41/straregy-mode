package com.boommanpro.springenumstrategypattern.common;

import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessType;
import com.boommanpro.springenumstrategypattern.module.report.enums.ProcessTypeEnumFlag;
import com.boommanpro.springenumstrategypattern.module.report.service.generatorreport.Strategy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 初始化策略map key-->策略枚举 value-->策略对应的具体实现
 * @author xlwang55
 */
@Component
public class ProcessTypeGeneratorReportConfig implements ApplicationContextAware, InitializingBean {

    public static Map<ProcessType, Strategy> generatorStrategyMap;

    private ApplicationContext applicationContext;

    private ProcessTypeGeneratorReportConfig() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initGeneratorStrategyMap();
    }

    private void initGeneratorStrategyMap() {
        //获取所有关于Strategy的bean
        Map<String, Strategy> beanMap = applicationContext.getBeansOfType(Strategy.class);
        //策略枚举与具体策略实现关联(将标注了@ProcessTypeEnumFlag注解的类和枚举做关联)
        Map<ProcessType, Strategy> result = EnumBeanMapUtil.beanMap2EnumMap(beanMap, ProcessTypeEnumFlag.class,
                ProcessTypeEnumFlag::value);
        setGeneratorStrategyMap(result);
    }

    /**
     * @param generatorStrategyMap key枚举，value对应的实现
     * @return
     * @author xlwang55
     * @date 2022/2/9
     */
    private static void setGeneratorStrategyMap(Map<ProcessType, Strategy> generatorStrategyMap) {
        ProcessTypeGeneratorReportConfig.generatorStrategyMap = generatorStrategyMap;
    }


}