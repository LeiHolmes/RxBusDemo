package com.leiholmes.rxbusdemo.entity;

/**
 * Description:   消息实体2
 * author         xulei
 * Date           2017/11/24
 */

public class PostMessage2 {
    private String message;

    public PostMessage2() {
    }

    public PostMessage2(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PostMessage2{" +
                "message='" + message + '\'' +
                '}';
    }
}
