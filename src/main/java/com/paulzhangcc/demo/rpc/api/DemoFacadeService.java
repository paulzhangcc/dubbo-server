package com.paulzhangcc.demo.rpc.api;

import com.paulzhangcc.demo.rpc.dto.DemoDTO;

import java.util.List;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public interface DemoFacadeService {

    /**
     *
     * @return
     */
    List<DemoDTO> top();
}
