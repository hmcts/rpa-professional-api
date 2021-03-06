package uk.gov.hmcts.reform.rpa.papi.unit.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GetWelcomeTest {

    @Autowired
    private transient MockMvc mockMvc;

    @Test
    public void should_root_request_with_200_response_code() throws Exception {
        MvcResult response = mockMvc.perform(get("/")).andExpect(status().isOk()).andReturn();

        assertThat(response.getResponse().getContentAsString()).startsWith("pong");
    }

    @Test
    public void should_hello_request_with_200_response_code() throws Exception {
        MvcResult response = mockMvc.perform(get("/hello")).andExpect(status().isOk()).andReturn();

        assertThat(response.getResponse().getContentAsString()).startsWith("Welcome");
    }

    @Test
    public void should_true_request_with_200_response_code() throws Exception {
        MvcResult response = mockMvc.perform(get("/true")).andExpect(status().isOk()).andReturn();

        assertThat(response.getResponse().getContentAsString()).contains("true");
    }
}
