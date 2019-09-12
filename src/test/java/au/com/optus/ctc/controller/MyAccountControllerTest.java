package au.com.optus.ctc.controller;


import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.GenderEnum;
import au.com.optus.ctc.service.MyAccountServiceIF;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MyAccountController.class)
public class MyAccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MyAccountServiceIF service;

    @Autowired
    ObjectMapper mapper;
    private static final String API_ROOT = "http://localhost:9090/api/ctc";


    @WithMockUser("root")
    @Test
    @Ignore
    public void whenCreateNewBook_thenCreated() throws Exception {
        AccountProfile profile = new AccountProfile("firstName4","lastname", 45, GenderEnum.F, "user", new Date(12/12/1984),"043234244", "email4@mail.com", "2113");
        String json = mapper.writeValueAsString(profile);
        System.out.println("AccountProfile {}"+json);
        mvc.perform(post("http://localhost:9090/api/ctc/myaccount/accountProfile")
                .content(json).accept(MediaType.APPLICATION_JSON)
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8"))
                .andExpect(status().isOk());
    }
}
