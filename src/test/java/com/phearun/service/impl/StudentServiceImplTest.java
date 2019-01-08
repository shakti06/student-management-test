package com.phearun.service.impl;

import com.phearun.model.Student;
import com.phearun.repository.StudentRepository;
import com.phearun.service.StudentService;
import com.phearun.utility.Paging;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    Student student;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() throws  Exception {
        //given
        List<Student> students = Arrays.asList(new Student(), new Student());

        Mockito.when(studentService.findAll()).thenReturn(students);

        List<Student> studentList = studentRepository.findAll();

        assertEquals(studentList.size(), 2);
        Mockito.verify(studentRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void findAll1() throws  Exception {
        Paging paging = new Paging();
        Mockito.when(studentRepository.findAll(Matchers.anyObject())).thenReturn(Matchers.anyObject());

        List<Student> studentList = studentRepository.findAll(paging);

        Mockito.verify(studentRepository, Mockito.times(1)).findAll(Matchers.anyObject());
    }

    @Test
    public void findOne() throws Exception {
        int id = 01;
        student = new Student();
        student.setId(id);
        Mockito.when(studentRepository.findOne(Matchers.anyInt())).thenReturn(student);

        Student student1 =  studentService.findOne(id);

        assertNotNull("null student returned", student1);
        Mockito.verify(studentRepository, Mockito.times(1)).findOne(Matchers.anyInt());
    }

    @Test
    public void remove() throws Exception {
        int id = 01;
        studentService.remove(id);

        Mockito.when(studentRepository.remove(Matchers.anyInt())).thenReturn(true);


        Mockito.verify(studentRepository, Mockito.times(1)).remove(Matchers.anyInt());

    }

    @Test
    public void save() throws  Exception {
            student = new Student();
            studentRepository.save(student);
            Mockito.when(studentRepository.save(student)).thenReturn(true);

            Mockito.verify(studentRepository, Mockito.times(1)).save(student);
    }

    @Test
    public void update() throws Exception {
        student = new Student();
        studentRepository.update(student);

        Mockito.when(studentRepository.update(student)).thenReturn(true);
        Mockito.verify(studentRepository, Mockito.times(1)).update(student);
    }
}