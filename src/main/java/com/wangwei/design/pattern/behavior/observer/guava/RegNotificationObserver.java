package com.wangwei.design.pattern.behavior.observer.guava;

import com.google.common.eventbus.Subscribe;
import com.wangwei.design.pattern.behavior.observer.NotificationService;

/**
 * @Author wangwei
 * @Date 2020/4/26 9:38 上午
 * @Version 1.0
 */
public class RegNotificationObserver {
    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "...");
    }
}
