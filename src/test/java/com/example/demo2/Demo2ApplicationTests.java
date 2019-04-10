package com.example.demo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {

    @Test
    public void contextLoads() {
    }

    private MockMvc mvc;

//    @Before
//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
//    }
//
//    @Test
//    public void getHello() throws Exception {
////         given(this.modelProductService.get(anyLong()))
////                .willReturn(null);
//        RequestBuilder requestBuilder = null;
//        requestBuilder = get("/hello").contentType(MediaType.APPLICATION_JSON).content("");
//        mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().string("{}"));
//
//
//    }

}