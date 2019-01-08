package com.phearun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.phearun.model.Student;
import com.phearun.service.StudentService;
import com.phearun.utility.Paging;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentControllerTest {
    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    MockMvc mockMvc;

    Student student;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }



    @Test
    public void findAll() throws Exception {
        List<Student> studentList = Arrays.asList(new Student(), new Student());
        Mockito.when(studentService.findAll()).thenReturn(studentList);

        List<Student> students = studentService.findAll();
        Mockito.verify(studentService, Mockito.times(1)).findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }



    @Test
    public void find() throws  Exception {
        List<Student> studentList = Arrays.asList(new Student(), new Student());
        Mockito.when(studentService.findAll()).thenReturn(studentList);

        List<Student> students = studentService.findAll();
        Mockito.verify(studentService, Mockito.times(1)).findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/lst")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }



    @Test
    public void findO() throws Exception {
        student = new Student();
        student.setId(01);
        student.setFirstname("ryan");

        Mockito.when(studentService.findOne(Matchers.anyInt())).thenReturn(student);

        Student student = studentService.findOne(Matchers.anyInt());
        Mockito.verify(studentService, Mockito.times(1)).findOne(Matchers.anyInt());


        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/one/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.firstname" , CoreMatchers.equalTo("ryan")));

    }



    @Test
    public void findAll1() throws Exception{

        Paging paging = new Paging();
        List<Student> studentList = studentService.findAll(paging);
        Mockito.verify(studentService, Mockito.times(1)).findAll(paging);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/student")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }



    @Test
    public void findAll2() throws Exception {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        student = new Student(1, "shakti", "bhujel","male",true,timestamp,"2054-03-30","64656565","phto");

        Mockito.when(studentService.findOne(student.getId())).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/{id}", student.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());


        Mockito.verify(studentService, Mockito.times(1)).findOne(Matchers.anyInt());
    }



    @Test
    public void save() throws Exception{
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        student = new Student(1, "shakti", "bhujel","male",true,timestamp,"2054-03-30","64656565","phto");

        Mockito.when(studentService.save(student)).thenReturn(true);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/student")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }



    @Test
    public void remove() throws Exception{
        student = new Student();
        student.setId(1);

        Mockito.when(studentService.remove(student.getId())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/student/{id}", student.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(studentService, Mockito.times(1)).remove(student.getId());
        Mockito.verifyNoMoreInteractions(studentService);
    }



    @Test
    public void update() throws Exception{
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        student = new Student(1, "shakti", "bhujel","male",true,timestamp,"2054-03-30","64656565","phto");
        Mockito.when(studentService.update(student)).thenReturn(true);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(student);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/student")
               .contentType(MediaType.APPLICATION_JSON_UTF8)
               .content(requestJson))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }
}