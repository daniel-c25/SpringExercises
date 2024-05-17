package testcrud;

import com.fasterxml.jackson.databind.ObjectMapper;

import testcrud.student.Student;
import testcrud.student.StudentController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {


    @Autowired
    StudentController studentController;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void addUser() throws Exception {
        Student student = Student.StudentBuilder.aStudent()
                .withId(1L)
                .withName("Fabio")
                .withSurname("Petrosillo")
                .withIsWorking(true)
                .build();

        this.mockMvc.perform(post("/student/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void isGettingStudents() throws Exception {
        this.mockMvc.perform(get("/student/all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    void isGettingStudent() throws Exception {
        this.mockMvc.perform(get("/student/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void isUpdatingStudent() throws Exception {

        Student student = Student.StudentBuilder.aStudent()
                .withId(1L)
                .withName("Bafio")
                .withSurname("Petrosillo")
                .withIsWorking(true)
                .build();

        MvcResult mvcResult = this.mockMvc.perform(put("/student/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Student student1 = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Student.class);

        Assertions.assertEquals(student1.getId(), student.getId());
    }

    @Test
    void isWorking() throws Exception {
        Student student = Student.StudentBuilder.aStudent()
                .withId(1L)
                .withName("Fabio")
                .withSurname("Petrosillo")
                .withIsWorking(true)
                .build();

        MvcResult mvcResult = this.mockMvc.perform(put("/student/updateIsWorking/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Student student1 = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Student.class);

        Assertions.assertNotEquals(student1.isWorking(), student.isWorking());
    }

    @Test
    void deleteStudent() throws Exception {
        this.mockMvc.perform(delete("/student/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}