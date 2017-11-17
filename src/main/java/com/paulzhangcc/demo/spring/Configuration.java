package com.paulzhangcc.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;

/**
 * Created by paul on 2017/11/17.
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    public static final String ASYNC_LISTENER = "ASYNC_LISTENER";

    @Bean(ASYNC_LISTENER)
    public TaskExecutorFactoryBean ayncListener(){
        TaskExecutorFactoryBean taskExecutorFactoryBean = new TaskExecutorFactoryBean();
        taskExecutorFactoryBean.setBeanName(ASYNC_LISTENER);
        return taskExecutorFactoryBean;
    }
}
