package com.cyy;

/**
 * @author:CYY
 * @create: 2023-06-12 09:24:05
 * @Description:
 */
public class WeixinUser implements Observer {
    // 微信用户名
    private String name;
    public WeixinUser(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }


}
