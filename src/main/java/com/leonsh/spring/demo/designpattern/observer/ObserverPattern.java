package com.leonsh.spring.demo.designpattern.observer;

import lombok.AllArgsConstructor;

import java.util.Observable;
import java.util.Observer;

/**
 * ObserverPattern
 *
 * @author leonsh
 * @date 2020-12-01 09:06
 **/
public class ObserverPattern {

    public static void main(String[] args) {
        /**
         * Observer 和 Observable 都是JDK自带的，不需要自己的写
         * 在改变的地方需要调用this.setChanged(), 因为你需要自己
         * 去判断，当前的值是否是更新了，因为它的值可能跟上次一样
         * 这样一来就没有必要通知观察者
         */
        Subject subject = new Subject(2);
        Observer observer = new ConcreteObserver();
        subject.addObserver(observer);

        subject.setState(4);
        subject.setState(7);
    }

    @AllArgsConstructor
    public static class Subject extends Observable {
        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            this.setChanged();
            this.notifyObservers(state);
        }
    }

    public static class ConcreteObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            Subject subject = (Subject) o;
            int state = subject.getState();
            System.out.println("目标对象的状态变化成为：" + state);
        }
    }
}
