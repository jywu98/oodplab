package teamassignment;

import java.util.Scanner;

public class AdminAccount extends UserAccount{

	public AdminAccount(String username, String password, boolean admin, String name, String gender, String nationality, String email) {
		super(username, password, admin, name, gender, nationality, email);
	}
	
	public void editAccessPeriod() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter initial access period date: ");
		String initial = sc.next();
		System.out.println("Enter final access period date: ");
		String finaldate = sc.next();
		
	}
	
	public void addStudent(String username, String password, boolean admin, String gender, String nationality, String email, int auLimit, String matricnumber) {
		StudentAccount newstudent = new StudentAccount(username, hashtool.getHash(password), admin, gender, nationality, email, auLimit, matricnumber);
		UserList.addAccount(newstudent);
		
		
		
	}
	
	public void addCourse(String coursecode, String courseName, int au) {
		Course newcourse = new Course( coursecode, courseName, au);
		courseLinkList.addCourse(newcourse);
	}
	
	
	public void updateCourseIndex(courseLinkList mycourselist, int oldindex, int newindex) {
		
		for (int i = 0; i< courseLinkList.length(); i++)
		{			
			if (courseLinkList.get(i).get == oldindex) //mycourse-> get arraylist of index-> get specific index-> get index name of index ==oldindex
			{
				mycourse.getIndex().get(i).setIndex(newindex); //mycourse->get arraylist of index-> get specific index-> set index name of index
			}
		}
		
	}
	
	public void updateCourseCode(Course mycourse, String newcoursecode) {
		mycourse.setCourseCode(newcoursecode);
			
	}
	
	
	public void printEnrollees(Index myindex) {
		myindex.printEnrollees();

	}
	
	public void printEnrollees(Course mycourse, String courseCode) {//This method doesnt make sense. Are we printing out literally all students taking the course? 
		for(int i = 0; i< mycourse.getIndex().length(); i++)
		{
			mycourse.getIndex().get(i).printEnrollees(); //mycourse-> get arraylist of indexes-> for each index-> print enrollees;
			
		}	
			
			
			
}
