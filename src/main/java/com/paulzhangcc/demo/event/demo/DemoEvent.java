package com.paulzhangcc.demo.event.demo;

import org.springframework.context.ApplicationEvent;

/**
 * Created by paul on 2017/11/16.
 */
public class DemoEvent extends ApplicationEvent {

    public DemoEvent(Object source) {
        super(source);
    }
}
