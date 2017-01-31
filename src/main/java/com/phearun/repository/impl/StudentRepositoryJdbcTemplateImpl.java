package com.phearun.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.phearun.model.Student;
import com.phearun.repository.StudentRepository;
import com.phearun.utility.Paging;

@Repository("jdbcTemplateImplementation")
public class StudentRepositoryJdbcTemplateImpl implements StudentRepository{

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll(Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
