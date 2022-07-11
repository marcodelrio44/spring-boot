package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository repository) {
		studentRepository=repository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
		
		if(studentOptional.isPresent())
			throw new IllegalStateException("email already taken!");
		
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists=studentRepository.existsById(studentId);
		
		if(!exists)
			throw new IllegalStateException("student with id " + studentId + " does not exists");
		
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student=studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student does not exist"));
		
		if(name!=null && name.length()>0 && !Objects.equals(name,student.getFirstName()))
			student.setFirstName(name);
		if(email!=null && email.length()>0 && !Objects.equals(name,student.getEmail())) {
			Optional<Student> s = studentRepository.findStudentByEmail(email);
			
			if(s.isPresent()) {
				throw new IllegalStateException("email already taken");
			}
			
			student.setEmail(email);
		}
			
		
		
		
	}
	
	
}
