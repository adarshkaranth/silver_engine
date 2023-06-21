package com.sdmit.demo.service;

import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.ArrayList;

import com.sdmit.demo.dto.Student;

//TODO: Change to Interface & Impli
public class StudentService {
	public static final String STUDENTS_KEY = "students";
	
	public List<Student> listStudents(Map<String, Object> session) {
		List<Student> studentList = null;
		System.out.println("listStudents:");
		//TODO:Perform DB Operation
		 
		if(session.get(STUDENTS_KEY)==null) {
			studentList = new ArrayList<Student>();
		// Add dummy student data
			Random random = new Random();
			studentList.add(new Student(Integer.toString(random.nextInt()),"Ramesh", "Rao", "ramesh@example.com", "1234567890"));
			studentList.add(new Student(Integer.toString(random.nextInt()),"Vikas", "Nayak", "vikas@example.com", "9876543210"));
			studentList.add(new Student(Integer.toString(random.nextInt()),"Ramya", "Poojari", "ramya@example.com", "5555555555"));
			updateSession(session,studentList);
		} else {
			studentList = (List<Student>) session.get(STUDENTS_KEY);
		}
		
		return studentList;
	}
	
	public Student getStudent(Map<String, Object> session, String studentId) {
		System.out.println("getStudent..");
		//TODO:Perform DB Operation
		List<Student> studentList = this.listStudents(session);
		System.out.println(studentList);
		return studentList.get(this.getStudentIndex(studentList,studentId));
	}
	
	private int getStudentIndex(List<Student> studentList, String studentId) {
		System.out.println("getStudentIndex..");
		 int studentIndex = 100;
		 System.out.println("studentId to get-->"+studentId+"<--");
		System.out.println(studentList);
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			if(studentId.equals(student.getId())) {
				//System.out.println(student);
				System.out.println("student.getId()-->"+student.getId()+"<--");
				studentIndex = i;
				System.out.println("studentIndex:"+studentIndex);
				break;
			}
		} 
		 
		return studentIndex;
	}
	
	public Student saveStudent(Map<String, Object> session, Student student) {
		
		//TODO:Perform DB Operation
		List<Student> studentList = this.listStudents(session);
		boolean result = studentList.add(student);
		System.out.println("registerStudent:"+ result);
		updateSession(session,studentList);
		
		return student;
	}
	
	public Student updateStudent(Map<String, Object> session, Student student) {
		
		//TODO:Perform DB Operation
		List<Student> studentList = this.listStudents(session);
		Student remStudent = this.getStudent(session,  student.getId());
		boolean remove = studentList.remove(remStudent);
		boolean add = studentList.add(student);
		 
		System.out.println("updateStudent:"+ remove + "; "+add);
		updateSession(session,studentList);
		return student;
	}
 
	 
	public boolean deleteStudent(Map<String, Object> session, String id) {
		//TODO:Perform DB Operation
		Student student = this.getStudent(session, id);
		List<Student> studentList = this.listStudents(session);
		boolean result = studentList.remove(student);
		System.out.println("deleteStudent:"+ result);
		updateSession(session,studentList);
		return result;
	}
	
	
	private void updateSession(Map<String, Object> session,List<Student> studentList) {
		System.out.println("updateSession:");
		session.put(STUDENTS_KEY, studentList);
	}
}
