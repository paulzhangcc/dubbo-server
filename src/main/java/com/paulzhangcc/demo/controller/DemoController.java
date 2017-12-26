package com.paulzhangcc.demo.controller;


import com.paulzhangcc.demo.dao.mysql.DO.DemoDO;
import com.paulzhangcc.demo.dao.mysql.mapper.DemoDAO;
import com.paulzhangcc.demo.event.demo.DemoEvent;
import com.paulzhangcc.demo.rpc.api.DemoFacadeService;
import com.paulzhangcc.demo.rpc.dto.DemoDTO;
import com.paulzhangcc.demo.service.api.DemoService;
import com.paulzhangcc.sharing.message.SmsFacade;
import com.paulzhangcc.sharing.spring.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by paul on 2017/11/16.
 */
@RestController
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private DemoService demoService;
    @Autowired
    SmsFacade smsFacade;
    @Autowired
    private DemoFacadeService demoFacadeService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private DemoDAO demoDAO;

    @RequestMapping("/insert")
    public String insert() {
        DemoDO demo = new DemoDO();
        demo.setAge(11);
        demo.setUserName("张呵呵");

        int insert = demoService.insert(demo);
        logger.info("插入成功:" + demo);
        if (insert == 1) {
            ApplicationContextHelper.applicationContext.publishEvent(new DemoEvent(this));
            return "Y";
        }
        return "N";
    }

    @RequestMapping("/top10")
    public List<DemoDTO> top10() {
        return demoFacadeService.top();
    }


    @RequestMapping("/limit")
    public List<DemoDO> limit(Integer offset, Integer pagesize) {

        return demoService.limit(offset, pagesize);
    }

    @RequestMapping("/set")
    public boolean set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    @RequestMapping("/get")
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/update")
    public int update() {
        DemoDO demoDO = new DemoDO();
        demoDO.setId(-1L);
        demoDO.setAge(1);
        return demoDAO.updateByPrimaryKeySelective(demoDO);
    }

    @RequestMapping("/sendMessage")
    public boolean sendMessage() {
        return smsFacade.sendVerificationCode("18600787844", "11111");
    }

}
