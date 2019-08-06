package controller;

import java.util.*;

import dao.StudentDao;
import model.Student;
public class StudentController {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	
		while(true) 
		{
			System.out.println();

			System.out.println("Please Choose from menu below");
			System.out.println();

			System.out.println("1) Insert  2) Update ");
			System.out.println("3) Read    4) Delete ");
			System.out.println();

			
			int input = sc.nextInt();
			
			switch(input) 
			{
			case 1:
				InsertAction();
				break;
			case 2:
				updateAction();
				break;
			case 3:
				GetAll();
				break;
			case 4:
				DeleteAction();
				break;
			default:
				System.out.println("Invalid Input");
				break;
				
			}
		}


	}
	
	public static void InsertAction() 
	{
		System.out.println("Enter student name");
	    String name = sc.next();
		System.out.println("Enter student gender");
	    String gender = sc.next();
	    
	    Student st = new Student();
	    st.setName(name);
	    st.setGender(gender);
	    
	    StudentDao.insertData(st);


	}
	
	public static void DeleteAction() 
	{
		System.out.println("Enter student id to delete");
	    int id = sc.nextInt();
		
	    
	    StudentDao.deleteDelete(id);


	}
	public static void updateAction() 
	{
		System.out.println("Enter student name");
	    String name = sc.next();
		System.out.println("Enter student gender");
	    String gender = sc.next();
		System.out.println("Enter student ID");
		int id = sc.nextInt();

	    
	    Student st = new Student();
	    st.setName(name);
	    st.setGender(gender);
	    st.setId(id);
	    
	    StudentDao.updateRecord(st);


	}

	public static void GetAll() 
	{
		
		List<Student> students = StudentDao.getAll();
		
		for(Student st: students) 
		{
			System.out.println(st.getId() + " "+ st.getName() + " " + st.getGender());
		}
	}
}
