package com.phearun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.phearun.model.Student;
import com.phearun.repository.StudentRepository;
import com.phearun.service.StudentService;
import com.phearun.utility.Paging;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	@Qualifier("memoryImplementation")
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findAll(Paging paging) {
		paging.setTotalCount(10L);
		return studentRepository.findAll(paging);
	}

	@Override
	public Student findOne(int id) {
		return studentRepository.findOne(id);
	}

	@Override
	public boolean remove(int id) {
		return studentRepository.remove(id);
	}

	@Override
	public boolean save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public boolean update(Student student) {
		return studentRepository.update(student);
	}

}
