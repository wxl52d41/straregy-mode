package com.boommanpro.springenumstrategypatternThree.handler;


import com.boommanpro.springenumstrategypatternThree.enmus.AuthTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lihui
 * @since 2024/3/11
 */
@Slf4j
@Service
public class CaptchaLoginService extends AbstractLoginService {

    @Override
    public String getType() {
        return AuthTypeEnum.MOBILE.getCode();
    }

    @Override
    protected void doLogin(String authType) {
      log.info("验证码登录");
    }



    @Override
    protected String loginFinal(String authType) {
        return authType;
    }
}
