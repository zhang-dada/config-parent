package com.client.web;

import com.alibaba.fastjson.JSON;
import com.client.config.ConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestConfig2Controller {
    @Autowired
    private ConfigEntity configEntity;
    @RequestMapping("test001")
    public String test(){
        return JSON.toJSONString(configEntity);
    }
}
