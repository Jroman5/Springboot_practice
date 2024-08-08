package com.example.databaseDemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.databaseDemo.dao.StudentDAO;
import com.example.databaseDemo.enitity.Student;

@SpringBootApplication
public class DatabaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}
	//test
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

			createMultipleStudents(studentDAO);
			// System.out.println("hello world");

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO){

		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("bob","Doe","jd@gmail.com");
		Student tempStudent2 = new Student("bill","public","mary@gmail.com");
		Student tempStudent3 = new Student("Boe","Applebum","bon@gmail.com");

		System.out.println("saving students");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("students saved: printing ids: " + tempStudent1.getId() + " " + tempStudent2.getId() + " " + tempStudent3.getId());


	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Createing new Student object...");
		Student tempStudent = new Student("Paul","Doe","paul@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student. generated id: " + tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO){
		//create, save, display id, retrieve student, display

		Student tmpStudent = new Student("bob", "bill", "bbl@gmail.com");

		studentDAO.save(tmpStudent);

		System.out.println("student saved: student id: " + tmpStudent.getId());

		Student tmpStudent2 = studentDAO.findById(tmpStudent.getId());

		System.out.println("student found: student info: " + tmpStudent2.toString() );
	}

	private void queryForStudents(StudentDAO studentDAO){
		
		
		
		List<Student> list = studentDAO.findAll();

		for(Student item:list){
			System.out.println(item.toString());
		}
	}

	private void updateStudent(StudentDAO studentDAO){
		// retrieve student based on id
		int studentId = 1;

		//change firstname
		System.out.println("getting student by id...");

		Student myStudent = studentDAO.findById(studentId);

		myStudent.setFirstName("SCOOBY");

		studentDAO.update(myStudent);

		System.out.println("Student updated: new values: " + myStudent.toString());


		// up[date studfent
		
		// display student
	}

	private void deleteStudent(StudentDAO studentDAO){
		int studentId = 2;
		System.out.println("deleting student 2: ");

		studentDAO.delete(studentId);
	}

}
