package com.phearun.repository.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.phearun.model.Student;
import com.phearun.repository.StudentRepository;
import com.phearun.utility.Paging;

@Repository("memoryImplementation")
public class StudentRepositoryMemoryImpl implements StudentRepository{

	private List<Student> students;
	
	public StudentRepositoryMemoryImpl() {
		 students = new ArrayList<>();
		 for(int i=0; i<10; i++){
			students.add(new Student(i, "fn" + i, "ln"+i, i/2==0?"M":"F", true, new Timestamp(new Date().getTime()), "PP", "012 222 34" + i, "url"));
		 }
	}
	
	@Override
	public List<Student> findAll() {
		return students;
	}

	@Override
	public List<Student> findAll(Paging paging) {
		List<Student> studentss = new ArrayList<>();

		int startIndex = paging.getOffset();
		int endIndex = paging.getOffset() + paging.getLimit();
		
		if (endIndex > students.size())
			endIndex = students.size();
		
		if(paging.getPage() > 0){
			for(int i=startIndex; i<endIndex; i++){
				studentss.add(students.get(i));
			}
		}
		return studentss;
	}

	@Override
	public Student findOne(int id) {
		for(Student student: students){
			if(student.getId() == id)
				return student;
		}
		return null;
	}

	@Override
	public boolean remove(int id) {
		for(Student student: students){
			if(student.getId() == id)
				return students.remove(student);
		}
		return false;
	}

	@Override
	public boolean save(Student student) {
		return students.add(student);
	}

	@Override
	public boolean update(Student student) {
		for(Student st: students){
			if(student.getId() == st.getId()){
				st = student;
				return true;
			}
		}
		return false;
	}

	@Override
	public long count() {
		return students.size();
	}

}
