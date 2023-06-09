package com.cyy;

/**
 * @author:CYY
 * @create: 2023-06-12 09:24:31
 * @Description:
 */
public interface Subject {
    /**
     * 增加订阅者
     * @param observer
     */
    public void attach(Observer observer);
    /**
     * 删除订阅者
     * @param observer
     */
    public void detach(Observer observer);
    /**
     * 通知订阅者更新消息
     */
    public void notify(String message);
}
