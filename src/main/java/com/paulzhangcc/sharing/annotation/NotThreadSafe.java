package com.paulzhangcc.sharing.annotation;

import java.lang.annotation.*;

/**
 *  标记为非线程安全的注解，标示类或者方法不是必须线程安全实现的
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotThreadSafe {

}
