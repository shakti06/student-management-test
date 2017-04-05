/*package com.phearun.repository.impl.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phearun.model.Student;
import com.phearun.repository.StudentRepository;
import com.phearun.utility.Paging;

@Repository("mybatisImplementation")
public class StudentRepositoryMybatisImpl implements StudentRepository{

	@Autowired
	private StudentRepositoryMybatis studentRepository;
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findAll(Paging paging) {
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

	@Override
	public long count() {
		return studentRepository.count();
	}

}
*/