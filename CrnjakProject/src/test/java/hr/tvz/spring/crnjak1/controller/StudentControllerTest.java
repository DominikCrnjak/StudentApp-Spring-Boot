package hr.tvz.spring.crnjak1.controller;


import hr.tvz.spring.crnjak1.command.StudentCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.time.LocalDate;

import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {



    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllStudents() throws Exception {
        this.mockMvc.perform(
                        get("/student")
                                .with(user("admin")
                                        .password("test")
                                        .roles("ADMIN")
                                )
                                .with(csrf())

                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void getStudentByJMBAG() throws Exception {
        this.mockMvc.perform(
                        get("/student").param("JMBAG","0246053995")
                                .with(user("admin")
                                        .password("test")
                                        .roles("ADMIN")
                                )
                                .with(csrf())


                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",aMapWithSize(3)));
    }

    @Test
    void save() throws Exception {
        StudentCommand studentCommand=new StudentCommand("Damir","Deda","123456783", LocalDate.now().minusYears(10),3);
        this.mockMvc.perform(
                        post("/student")
                                .with(user("admin")
                                        .password("test")
                                        .roles("ADMIN")
                                )
                                .with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                        "    \"firstName\":\"admin\",\n" +
                                        "    \"lastName\":\"test\",\n" +
                                                "    \"jmbag\":\"123456789\",\n"+
                                        "    \"dateOfBirth\":\"11.11.2001.\",\n" +
                                        "    \"numberOfECTS\":\"3\"\n" +
                                        "}")
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    void delete() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/student/0246053995")

                                .with(user("admin")
                                        .password("test")
                                        .roles("ADMIN")
                                )
                                .with(csrf())


                )
                .andExpect(status().isOk());
    }
}