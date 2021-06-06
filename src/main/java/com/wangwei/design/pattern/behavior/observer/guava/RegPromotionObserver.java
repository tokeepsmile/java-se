package com.wangwei.design.pattern.behavior.observer.guava;

import com.google.common.eventbus.Subscribe;
import com.wangwei.design.pattern.behavior.observer.PromotionService;

/**
 * @Author wangwei
 * @Date 2020/4/26 9:37 上午
 * @Version 1.0
 */
public class RegPromotionObserver {
    private PromotionService promotionService; // 依赖注入

    @Subscribe
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}