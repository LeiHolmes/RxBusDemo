package com.leiholmes.rxbusdemo.util;


import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.subscribers.SerializedSubscriber;

/**
 * Description:   RxBus
 * author         xulei
 * Date           2017/11/17
 */

public class RxBus {
    private static volatile RxBus instance = null;
    //相当于Rxjava1.x中的Subject
    private final FlowableProcessor<Object> bus;

    private RxBus() {
        //RxJava2中使用toSerialized()方法，保证线程安全
        bus = PublishProcessor.create().toSerialized();
    }

    public static synchronized RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    /**
     * 发送消息
     */
    public void post(Object o) {
        new SerializedSubscriber<>(bus).onNext(o);
    }

    /**
     * 确定接收消息的类型
     */
    public <T> Flowable<T> toFlowable(Class<T> tClass) {
        return bus.ofType(tClass);
    }

    /**
     * 判断是否有订阅者
     */
    public boolean hasSubscribers() {
        return bus.hasSubscribers();
    }
}
