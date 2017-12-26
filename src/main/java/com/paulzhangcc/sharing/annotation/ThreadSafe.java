package com.paulzhangcc.sharing.annotation;

import java.lang.annotation.*;

/**
 * 标记为线程安全的注解，标示类或者方法必须是线程安全实现
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThreadSafe {

}