package org.jsp.Controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.DAO.StudentDao;
import org.jsp.DTO.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Jdbc_Template.xml");
		StudentDao dao = context.getBean(StudentDao.class);
		boolean b = true;
		while (b) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 1 for Save Student:");
			System.out.println("Enter 2 for Update Student By Id:");
			System.out.println("Enter 3 for Delete Student By Id:");
			System.out.println("Enter 4 for Fetch Student By Id:");
			System.out.println("Enter 5 For Fetch All Student:");
			int choice = sc.nextInt();
			switch (choice) {
			// Inserting Student DAta:
			case 1:
				Student s = new Student();
				System.out.println("Entr Student Id:");
				s.setId(sc.nextInt());
				System.out.println("Enter Student NAme:");
				s.setName(sc.next());
				System.out.println("Enter Student Phone:");
				s.setPhone(sc.nextLong());
				System.out.println("Enter Student Email:");
				s.setEmail(sc.next());
				System.out.println("Enter Student PAssword:");
				s.setPassword(sc.next());
				int saveStudent = dao.saveStudent(s);
				System.out.println(" Student Saved with ID :" + s.getId());
				break;
			// Update Student By Id:
			case 2:
				Student s1 = new Student();
				System.out.println("Entr Student Id:");
				s1.setId(sc.nextInt());
				System.out.println("Enter Student NAme:");
				s1.setName(sc.next());
				System.out.println("Enter Student Phone:");
				s1.setPhone(sc.nextLong());
				System.out.println("Enter Student Email:");
				s1.setEmail(sc.next());
				System.out.println("Enter Student PAssword:");
				s1.setPassword(sc.next());
				int updateStudent = dao.updateStudent(s1);
				System.out.println(" Student Updated with ID :" + s1.getId());
				break;
			// Delete Student By Id:
			case 3:
				System.out.println("Enter Student Id to Delete Student Record:");
				int deleteByStudentId = dao.deleteByStudentId(sc.nextInt());
				System.out.println("Student Delete Successfully:");
				break;
			// Fetch Student By Id:
			case 4:
				System.out.println("Enter Student Id to Fetch Student Record:");
				List<Student> studentById = dao.getStudentById(sc.nextInt());
				for (Student st : studentById) {
					System.out.println(st.getId());
					System.out.println(st.getName());
					System.out.println(st.getPhone());
					System.out.println(st.getEmail());
					System.out.println(st.getPassword());
				}
				break;
			// Fetch All Student
			case 5:
				List<Student> allStudent = dao.getAllStudent();
				for (Student st : allStudent) {
					System.out.println(st.getId());
					System.out.println(st.getName());
					System.out.println(st.getPhone());
					System.out.println(st.getEmail());
					System.out.println(st.getPassword());
					System.out.println("_____________");
				}
				break;
			default:
				b = false;
				System.out.println("Invalid User Input Try Again:");
				break;
			}
		}
	}
}