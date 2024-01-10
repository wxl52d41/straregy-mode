package com.boommanpro.springenumstrategypatternTwo.login.handler.impl;


import com.boommanpro.springenumstrategypatternTwo.enmus.LoginTypeEnum;
import com.boommanpro.springenumstrategypatternTwo.entity.LoginInfo;
import com.boommanpro.springenumstrategypatternTwo.login.handler.LoginTypeHandler;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RadioTypeHandler
 * @Description: 账号密码登录策略类
 * @Author wxl
 * @Date 2024-01-10
 * @Version 1.0.0
 **/
@Component
public class PasswordTypeHandler implements LoginTypeHandler {

    String desc = LoginTypeEnum.PASSWORD.getDesc();

    @Override
    public LoginTypeEnum getHandlerType() {
        return LoginTypeEnum.PASSWORD;
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
