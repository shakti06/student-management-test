package com.phearun.repository.impl.file;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.phearun.model.Student;
import com.phearun.repository.StudentRepository;
import com.phearun.utility.Paging;

@Repository("fileImplementation")
public class StudentRepositoryFileImpl implements StudentRepository{

	@Override
	public List<Student> findAll() {
		return null;
	}

	@Override
	public List<Student> findAll(Paging paging) {
		return null;
	}

	@Override
	public Student findOne(int id) {
		return null;
	}

	@Override
	public boolean remove(int id) {
		return false;
	}

	@Override
	public boolean save(Student student) {
		return false;
	}

	@Override
	public boolean update(Student student) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

}
