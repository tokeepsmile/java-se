package com.wangwei.design.pattern.observer.pattern;


import com.wangwei.design.pattern.behavior.observer.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Author wangwei
 * @Date 2020/4/26 8:26 上午
 * @Version 1.0
 */
public class UserController {
    private UserService userService; // 依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();
    private Executor executor;

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);

        for (RegObserver observer : regObservers) {
            executor.execute(() -> {
                observer.handleRegSuccess(userId);
            });
        }

        return userId;
    }
}

