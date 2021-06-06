package com.wangwei.design.pattern.observer.pattern;


import com.wangwei.design.pattern.behavior.observer.PromotionService;

/**
 * @Author wangwei
 * @Date 2020/4/26 8:23 上午
 * @Version 1.0
 */
public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService;
    @Override
    public void handleRegSuccess(long userId) {
        new Thread(() -> {
            promotionService.issueNewUserExperienceCash(userId);
        }).start();
    }
}
