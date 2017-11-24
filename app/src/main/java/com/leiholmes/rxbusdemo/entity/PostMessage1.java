package com.leiholmes.rxbusdemo.entity;

/**
 * Description:   消息实体
 * author         xulei
 * Date           2017/11/24
 */

public class PostMessage1 {
    private String message;

    public PostMessage1() {
    }

    public PostMessage1(String message) {
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
        return "PostMessage1{" +
                "message='" + message + '\'' +
                '}';
    }
}
