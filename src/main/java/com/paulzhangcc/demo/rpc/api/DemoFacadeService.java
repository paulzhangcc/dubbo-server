package com.paulzhangcc.demo.rpc.api;

import com.paulzhangcc.demo.rpc.dto.DemoDTO;

import java.util.List;

/**
 * Created by paul on 2017/11/16.
 */
public interface DemoFacadeService {

    /**
     *
     * @return
     */
    List<DemoDTO> top();
}
