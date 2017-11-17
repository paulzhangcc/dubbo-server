package com.paulzhangcc.demo.service.api;

import com.paulzhangcc.demo.dao.oracle.DO.DemoDO;

import java.util.List;

/**
 * Created by paul on 2017/11/16.
 */
public interface DemoService {
    int insert(DemoDO demoDO);

    List<DemoDO> top();

    List<DemoDO> limit(Integer offset,Integer pagesize);
}
