package com.boommanpro.springenumstrategypatternThree;

import com.boommanpro.springenumstrategypatternThree.enmus.AuthTypeEnum;
import com.boommanpro.springenumstrategypatternThree.handler.AbstractLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginTest {


    @Test
    void loginPasswordTest() {
        String loginType = AuthTypeEnum.QCT_PASSWORD.code;
        String login = AbstractLoginService.login(loginType);
        System.out.println("login = " + login);
    }

    @Test
    void loginCaptchaTest() {
        String loginType = AuthTypeEnum.MOBILE.code;
        String login = AbstractLoginService.login(loginType);
        System.out.println("login = " + login);
    }



}
