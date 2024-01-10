package com.boommanpro.springenumstrategypatternTwo.login.handler;


import com.boommanpro.springenumstrategypatternTwo.enmus.LoginTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型工厂
 *
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class LoginTypeHandlerFactory implements InitializingBean {

    @Resource
    private List<LoginTypeHandler> loginTypeHandlerList;

    private Map<LoginTypeEnum, LoginTypeHandler> handlerMap = new HashMap<>();

    public LoginTypeHandler getHandler(String subjectType) {
        LoginTypeEnum subjectInfoTypeEnum = LoginTypeEnum.getByCode(subjectType);
        return handlerMap.get(subjectInfoTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (LoginTypeHandler loginTypeHandler : loginTypeHandlerList) {
            handlerMap.put(loginTypeHandler.getHandlerType(), loginTypeHandler);
        }
    }

}
