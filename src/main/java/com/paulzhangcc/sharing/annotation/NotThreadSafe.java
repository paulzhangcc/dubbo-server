package com.paulzhangcc.sharing.annotation;

import java.lang.annotation.*;

/**
 * 标记为非线程安全的注解，标示类或者方法不是必须线程安全实现的
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotThreadSafe {

}
