package com.wangwei.design.pattern.observer.pattern;


import com.wangwei.design.pattern.behavior.observer.NotificationService;

/**
 * @Author wangwei
 * @Date 2020/4/26 8:24 上午
 * @Version 1.0
 */
public class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService;
    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "");
    }
}
