package com.paulzhangcc.demo.service.impl;


import com.paulzhangcc.demo.dao.mysql.model.DemoDO;
import com.paulzhangcc.demo.dao.mysql.mapper.DemoDAO;
import com.paulzhangcc.demo.service.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paul on 2017/11/16.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDAO demoDAO;


    @Override
    @Transactional
    public int insert(DemoDO demoDO) {
        int insert = demoDAO.insert(demoDO);
        return insert;
    }


    @Override
    public List<DemoDO> limit(Integer offset, Integer pagesize) {
        return demoDAO.limit(offset,pagesize);
    }
}
