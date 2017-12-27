package com.paulzhangcc.demo.event.demo;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class DemoEvent extends ApplicationEvent {

    public DemoEvent(Object source) {
        super(source);
    }
}
