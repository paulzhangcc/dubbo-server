package com.paulzhangcc.demo.service.api;

import com.paulzhangcc.demo.dao.mysql.model.DemoDO;

import java.util.List;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public interface DemoService {
    int insert(DemoDO demoDO);

    List<DemoDO> limit(Integer offset, Integer pagesize);
}
