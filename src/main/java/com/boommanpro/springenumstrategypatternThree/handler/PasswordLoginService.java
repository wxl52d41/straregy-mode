package com.boommanpro.springenumstrategypatternThree.handler;


import com.boommanpro.springenumstrategypatternThree.enmus.AuthTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 密码方式认证登录策略类
 *
 * @author zhangyong
 * @version 1.0.0
 * @ClassName: PasswordLoginService
 * @date 2024/03/12
 **/
@Slf4j
@Component
public class PasswordLoginService extends AbstractLoginService {


    @Override
    public String getType() {
        return AuthTypeEnum.QCT_PASSWORD.getCode();
    }


    @Override
    protected void doLogin(String authType) {
        log.info("密码登录");
    }



    @Override
    protected String loginFinal(String authType) {
        return authType;
    }

}
