package com.phearun.model;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

public class StudentTest {
     Student student;

    @Before
    public void setUp() throws Exception {
        student = new Student();
    }

    @Test
    public void getId() {
        int id = 01;
        student.setId(id);
        assertEquals(id, student.getId());

    }

    @Test
    public void getFirstname() {
        String firstname = "shakti";
        student.setFirstname(firstname);
        assertEquals(firstname, student.getFirstname());
    }

    @Test
    public void getLastname() {
        String lastname = "shakti";
        student.setLastname(lastname);
        assertEquals(lastname, student.getLastname());
    }

    @Test
    public void getGender() {
        String gender = "male";
        student.setGender(gender);
        assertEquals(gender, student.getGender());
    }

    @Test
    public void isStatus() {
         Boolean status = true;
         student.setStatus(status);
         assertTrue(student.isStatus());
    }

    @Test
    public void getDob() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        student.setDob(timestamp);

        assertEquals(timestamp, student.getDob());

    }

    @Test
    public void getPob() {
        String pob = "hey";
        student.setPob(pob);
        assertEquals(pob, student.getPob());
    }

    @Test
    public void getPhone() {
        String phone = "545464";
        student.setPhone(phone);
        assertEquals(phone, student.getPhone());
    }

    @Test
    public void getPhoto() {
        String photo = "hello";
        student.setPhoto(photo);
        assertEquals(photo, student.getPhoto());
    }
}