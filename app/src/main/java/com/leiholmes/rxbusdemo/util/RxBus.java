package com.leiholmes.rxbusdemo.util;


import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import io.reactivex.subscribers.SerializedSubscriber;

/**
 * Description:   RxBus
 * author         xulei
 * Date           2017/11/17
 */

public class RxBus {
    private static volatile RxBus instance = null;
    //Flowable带背压
    private final Subject<Object> busOld;
    //Observable不带背压
    private final FlowableProcessor<Object> bus; //带背压

    private RxBus() {
        //RxJava2中使用toSerialized()方法，保证线程安全
        bus = PublishProcessor.create().toSerialized();
        busOld = PublishSubject.create().toSerialized();
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
     * 发送消息：背压
     */
    public void post(Object o) {
        bus.onNext(o);
    }

    /**
     * 发送消息
     */
    public void postOld(Object o) {
        busOld.onNext(o);
    }

    /**
     * 确定接收消息的类型：背压
     */
    public <T> Flowable<T> toFlowable(Class<T> eventType) {
        return bus.ofType(eventType);
    }

    /**
     * 确定接收消息的类型
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return busOld.ofType(eventType);
    }

    /**
     * 判断是否有订阅者：背压
     */
    public boolean hasSubscribers() {
        return bus.hasSubscribers();
    }

    /**
     * 判断是否有订阅者
     */
    public boolean hasObservers() {
        return busOld.hasObservers();
    }
}
