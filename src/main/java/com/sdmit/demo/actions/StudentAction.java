package com.sdmit.demo.actions;
 
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.sdmit.demo.dto.Student;
import com.sdmit.demo.service.StudentService;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport implements SessionAware{

	private String id;
	private String firstName;
    private String lastName;
    
    private String email;
    private String mobileNumber;
   
    private Map<String, Object> session;
    
    private StudentService studentService = new StudentService();
    private List<Student> students;
    private Student student;
    
 // Action method to handle the list operation
    public String list() {
     System.out.println("...................StudentAction:list");
    	this.setStudents(studentService.listStudents(session));
        // Return a success result
        return SUCCESS;
    }
     
    public String register() {
        // Perform registration logic here
    	System.out.println("Register Student:");
     
        return SUCCESS;
    }
    
    // Action method for student registration
    public String save() {
        // Perform registration logic here
    	System.out.println("Register Student:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Mobile Number: " + mobileNumber);
        Random random = new Random();
        Student student = new Student(Integer.toString(random.nextInt()),firstName,lastName,email,mobileNumber);
        
        studentService.saveStudent(session,student);
        return SUCCESS;
    }
 
    public String load() {
        System.out.println("...................StudentAction:load");
       	this.setStudent(studentService.getStudent(session,this.getId()));
           // Return a success result
           return SUCCESS;
       }
 
 // Action method to handle the update operation
    public String update() {
        
        System.out.println("Update Student:");
        System.out.println("ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Mobile Number: " + mobileNumber);
        
        Student student = new Student(id,firstName,lastName,email,mobileNumber);
        studentService.updateStudent(session,student);
        
        // Return a success result
        return SUCCESS;
    }

    // Action method to handle the delete operation
    public String delete() {
         
        System.out.println("Delete Student:");
        System.out.println("ID: " + id);
        studentService.deleteStudent(session,id);
        // Return a success result
        return SUCCESS;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
 
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	
}
