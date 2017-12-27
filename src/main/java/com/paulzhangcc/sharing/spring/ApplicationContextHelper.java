package com.paulzhangcc.sharing.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Component
public class ApplicationContextHelper implements ApplicationContextAware{

	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextHelper.class);
	
	public static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg) throws BeansException {
		ApplicationContextHelper.applicationContext = arg;
	}

	public static <T> T getBean(Class<T> var1){
		return applicationContext.getBean(var1);
	}
}
