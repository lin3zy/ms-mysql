package com.lzy.ms_mysql.controller;

import com.lzy.ms_mysql.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/master")
    public String master() {
        return testService.master();
    }

    @RequestMapping("/slave")
    public String slave() {
        return testService.slave();
    }
}
