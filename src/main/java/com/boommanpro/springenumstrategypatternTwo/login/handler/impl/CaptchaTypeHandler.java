package com.boommanpro.springenumstrategypatternTwo.login.handler.impl;


import com.boommanpro.springenumstrategypatternTwo.enmus.LoginTypeEnum;
import com.boommanpro.springenumstrategypatternTwo.entity.LoginInfo;
import com.boommanpro.springenumstrategypatternTwo.login.handler.LoginTypeHandler;
import org.springframework.stereotype.Component;

/**
 * 验证码登录策略类
 *
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class CaptchaTypeHandler implements LoginTypeHandler {

    String desc = LoginTypeEnum.CAPTCHA.getDesc();

    @Override
    public LoginTypeEnum getHandlerType() {
        return LoginTypeEnum.CAPTCHA;
    }

    @Override
    public void login(LoginInfo loginInfo) {
        System.out.println("普通移动端login " + desc+ "login" + loginInfo);
    }

    @Override
    public void pcLogin(LoginInfo loginInfo) {
        System.out.println("普通pc端登录-" + desc + "pcLogin" + loginInfo);
    }

    @Override
    public void quantumLogin(LoginInfo loginInfo) {
        System.out.println("量盾验证码登录-" + desc + "pcLogin" + loginInfo);
    }

    @Override
    public void pcQuantumLogin(LoginInfo loginInfo) {
        System.out.println("pc盾登录-" + desc + "pcQuantumLogin" + loginInfo);
    }


}
