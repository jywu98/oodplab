package teamassignment;

import java.security.NoSuchAlgorithmException;
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
	
	public void addStudent(accountLinkList userList, String username, String password, boolean admin, String name, String gender, String nationality, String email, int auLimit, String matricnumber) throws NoSuchAlgorithmException {
		hashing hashtool = new hashing();
		StudentAccount newstudent = new StudentAccount(username, hashtool.getHash(password), admin, name, gender, nationality, email, auLimit, matricnumber);
		userList.addAccount(newstudent);
	}
	
	public void addCourse(courseLinkList mycourselist, String coursecode, String courseName, int au) {
		Course newcourse = new Course(coursecode, courseName, au);
		mycourselist.addCourse(newcourse);
	}
	
	
	public void updateCourseIndex(courseLinkList mycourselist, String mycoursecode, int oldindex, int newindex) {
		
		for (int i = 0; i< mycourselist.getCourseList().size(); i++)
		{			
			if (mycourselist.getCourseList().get(i).getCourseCode() == mycoursecode) 
			{
				Course mycourse = mycourselist.getCourseList().get(i);
				
				for (int j = 0; j< mycourse.getIndex().size(); j++)
				{
					if (mycourse.getIndex().get(j).getIndex() == oldindex)
					{
						mycourse.getIndex().get(j).setIndex(newindex);	
					}
				}
			}
		}
		
	}
	
	public void updateCourseCode(courseLinkList mycourselist, String oldcoursecode, String newcoursecode) {
		
		for (int i = 0; i< mycourselist.getCourseList().size(); i++)
		{			
			if (mycourselist.getCourseList().get(i).getCourseCode() == oldcoursecode) 
			{
				mycourselist.getCourseList().get(i).setCourseCode(newcoursecode);
			}
		}
			
	}
	
	
	public void printEnrollees(int myindex) {
		Index selected = IndexMasterList.getIndex(myindex);
		selected.printEnrollees();
	}
	
	public void printEnrollees(Course mycourse, String courseCode) {//This method doesnt make sense. Are we printing out literally all students taking the course? 
		for(int i = 0; i< mycourse.getIndex().size(); i++)
		{
			mycourse.getIndex().get(i).printEnrollees(); //mycourse-> get arraylist of indexes-> for each index-> print enrollees;
			
		}	
			
	}			
			
}
