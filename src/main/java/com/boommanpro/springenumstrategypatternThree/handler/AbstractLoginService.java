package com.boommanpro.springenumstrategypatternThree.handler;



import com.boommanpro.springenumstrategypatternThree.config.ApplicationConfiguration;

import java.util.Map;


/**
  * 描述信息:
  *
  * @date  2024/10/13
  * @param * @param null:
  * @return * @return: null
  **/
public abstract class AbstractLoginService {
    public static String login( String authType) {
        Map<String, AbstractLoginService> LoginServices = ApplicationConfiguration.getBeansOfType(AbstractLoginService.class);
        for (AbstractLoginService loginService : LoginServices.values()) {
            if (loginService.getType().equals(authType)) {
                loginService.doLogin(authType);
                return loginService.loginFinal(authType);
            }
        }
        throw new RuntimeException("无效的登录方式");
    }


    public abstract String getType();

    protected abstract void doLogin(String authType);

    protected abstract String loginFinal(String authType);
}
