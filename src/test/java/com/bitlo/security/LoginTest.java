package com.bitlo.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {
        String username = "mev";
        String password = "123";

        String body = "{\"username\":\"" + username + "\", \"password\":\""
                + password + "\"}";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.replace("{\"access_token\": \"", "");
        String token = response.replace("\"}", "");

        mvc.perform(MockMvcRequestBuilders.get("/message")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
        System.out.println(response);
    }

    @Test
    public void nonexistentUserCannotGetToken() throws Exception {
        String username = "beder";
        String password = "1233";

        String body = "{\"username\":\"" + username + "\", \"password\":\""
                + password + "\"}";

        mvc.perform(MockMvcRequestBuilders.post("/v2/token")
                .content(body))
                .andExpect(status().isForbidden()).andReturn();
        System.out.println();
    }

}
