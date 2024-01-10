package com.boommanpro.springenumstrategypatternTwo;

import com.boommanpro.springenumstrategypatternTwo.enmus.LoginTypeEnum;
import com.boommanpro.springenumstrategypatternTwo.entity.LoginInfo;
import com.boommanpro.springenumstrategypatternTwo.login.context.LoginContextService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class pcquantumLoginTests {
    @Resource
    private LoginContextService loginContextService;

    @Test
    void loginPasswordTest() {
        String loginType = LoginTypeEnum.PASSWORD.code;
        loginContextService.pcQuantumLogin(new LoginInfo("18890907878", "100090"), loginType);
    }

    @Test
    void loginCaptchaTest() {
        String loginType = LoginTypeEnum.CAPTCHA.code;
        loginContextService.pcQuantumLogin(new LoginInfo("18890907878", "100090"), loginType);
    }

    @Test
    void loginFreeTest() {
        String loginType = LoginTypeEnum.FREE.code;
        loginContextService.pcQuantumLogin(new LoginInfo("18890907878", "100090"), loginType);
    }

}
