package com.paulzhangcc.sharing.annotation;

import java.lang.annotation.*;

/**
 *  标记为线程安全的注解，标示类或者方法必须是线程安全实现
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThreadSafe {

}