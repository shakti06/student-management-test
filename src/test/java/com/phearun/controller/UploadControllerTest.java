package com.phearun.controller;

import com.phearun.service.UploadService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

public class UploadControllerTest {
    @InjectMocks
    UploadController uploadController;

    @Mock
    UploadService uploadService;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(uploadController).build();
    }
    @Test
    public void upload() throws  Exception {
        MockMultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "some texts".getBytes());
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/upload/photo")
        .file(file)
        .param("photo","4"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}