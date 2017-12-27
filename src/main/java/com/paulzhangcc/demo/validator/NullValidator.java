package com.paulzhangcc.demo.validator;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class NullValidator {
    public static void main(String[] args) {
        Result result = FluentValidator.checkAll().doValidate().result(toSimple());
        System.out.println(result);
    }
}
