package com.paulzhangcc.demo.service.impl;

import com.paulzhangcc.demo.dao.oracle.DAO.DemoDAO;
import com.paulzhangcc.demo.dao.oracle.DO.DemoDO;
import com.paulzhangcc.demo.service.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by paul on 2017/11/16.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDAO demoDAO;

    @Override
    public int insert(DemoDO demoDO) {
        return demoDAO.insert(demoDO);
    }

    @Override
    public List<DemoDO> top() {
        return demoDAO.top10();
    }

    @Override
    public List<DemoDO> limit(Integer offset, Integer pagesize) {
        return demoDAO.limit(offset,pagesize);
    }
}
