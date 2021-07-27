package com.lzy.ms_mysql.service.impl;

import com.lzy.ms_mysql.annotation.DiyDataSource;
import com.lzy.ms_mysql.mapper.TestMapper;
import com.lzy.ms_mysql.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    @DiyDataSource("master")
    public String master() {
        return testMapper.test();
    }

    @Override
    @DiyDataSource("slave")
    public String slave() {
        return testMapper.test();
    }
}
