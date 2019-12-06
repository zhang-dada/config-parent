package com.client.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Component
public class TestTask {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Scheduled(cron = "0/5 * * * * ?")
    public void refresh() throws Exception {
        MockMvc build = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        build.perform(MockMvcRequestBuilders.post("http://localhost:20001/actuator/refresh"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
