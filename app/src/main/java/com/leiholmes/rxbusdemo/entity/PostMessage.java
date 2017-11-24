package com.leiholmes.rxbusdemo.entity;

/**
 * Description:   消息实体
 * author         xulei
 * Date           2017/11/24
 */

public class PostMessage {
    private String message;

    public PostMessage() {
    }

    public PostMessage(String message) {
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
        return "PostMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
