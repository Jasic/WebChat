package com.lemontree.test;


import com.lemontree.controller.ReqFromTerminal;
import com.lemontree.main.AppContextConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppContextConfig.class)
public class TestController {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ReqFromTerminal userController;//你要测试的Controller

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    public void testFindPageUsers() throws Exception {
        ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/sysconfig/user/findPageUsers")
                .accept(MediaType.APPLICATION_JSON).param("page", "1")
                .param("limit", "10"));
        MvcResult mr = ra.andReturn();
        String result = mr.getResponse().getContentAsString();
        System.out.println(result);
    }

    public void tesHandleCmd() throws Exception {
        ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/terminal/cmd")
                .accept(MediaType.APPLICATION_JSON).param("page", "1")
                .param("limit", "10"));
        MvcResult mr = ra.andReturn();
        String result = mr.getResponse().getContentAsString();
        System.out.println(result);
    }

}
