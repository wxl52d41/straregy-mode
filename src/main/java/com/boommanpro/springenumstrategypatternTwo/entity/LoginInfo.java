package com.boommanpro.springenumstrategypatternTwo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: LoginInfo
 * @Description: 登录信息
 * @Author wxl
 * @Date 2024-01-10
 * @Version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private String LoginId;

    private String AppId;

}
