package com.boommanpro.springenumstrategypatternTwo.login.context.impl;

import com.boommanpro.springenumstrategypatternTwo.entity.LoginInfo;
import com.boommanpro.springenumstrategypatternTwo.login.context.LoginContextService;
import com.boommanpro.springenumstrategypatternTwo.login.handler.LoginTypeHandlerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @ClassName: LoginContextServiceImpl
 * @Description: 该方法委托策略变量调用具体策略所实现的策略接口中的方法。
 * @Author wxl
 * @Date 2024-01-10
 * @Version 1.0.0
 **/
@Component
public class LoginContextServiceImpl implements LoginContextService {

    @Resource
    private LoginTypeHandlerFactory loginTypeHandlerFactory;

    @Override
    public void login(LoginInfo loginInfo, String loginType) {
        Optional.ofNullable(loginTypeHandlerFactory.getHandler(loginType))
                .orElseThrow(() -> new RuntimeException("无效的登录方式" + this))
                .login(loginInfo);
        //生成ticket

    }

    @Override
    public void pcLogin(LoginInfo loginInfo, String loginType) {
        Optional.ofNullable(loginTypeHandlerFactory.getHandler(loginType))
                .orElseThrow(() -> new RuntimeException("无效的登录方式" + this))
                .pcLogin(loginInfo);
    }

    @Override
    public void quantumLogin(LoginInfo loginInfo, String loginType) {
        Optional.ofNullable(loginTypeHandlerFactory.getHandler(loginType))
                .orElseThrow(() -> new RuntimeException("无效的登录方式" + this))
                .quantumLogin(loginInfo);
    }

    @Override
    public void pcQuantumLogin(LoginInfo loginInfo, String loginType) {
        Optional.ofNullable(loginTypeHandlerFactory.getHandler(loginType))
                .orElseThrow(() -> new RuntimeException("无效的登录方式" + this))
                .pcQuantumLogin(loginInfo);
    }
}
