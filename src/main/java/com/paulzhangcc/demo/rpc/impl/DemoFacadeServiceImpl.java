package com.paulzhangcc.demo.rpc.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.paulzhangcc.demo.rpc.api.DemoFacadeService;
import com.paulzhangcc.demo.rpc.dto.DemoDTO;
import com.paulzhangcc.demo.service.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@Service
public class DemoFacadeServiceImpl implements DemoFacadeService {
    @Autowired
    DemoService demoService;

    @Override
    public List<DemoDTO> top() {
        return null;
//        List<DemoDO> top = demoService.top();
//        List<DemoDTO> topDTO = new ArrayList<>();
//        top.stream()
//                .forEach(demoDo -> {
//                            DemoDTO demoDTO = new DemoDTO();
//                            BeanCopier.create(DemoDO.class, DemoDTO.class, false).copy(demoDo, demoDTO, null);
//                            topDTO.add(demoDTO);
//                        }
//                );
//
//
//        return topDTO;
    }
}
