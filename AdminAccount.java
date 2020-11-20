package teamassignment;

import java.util.Scanner;

public class AdminAccount extends UserAccount{

	public AdminAccount(String username, String password, boolean admin, String gender, String nationality, String email) {
		super(username, password, admin, gender, nationality, email);
	}
	
	public void editAccessPeriod() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter initial access period date: ");
		String initial = sc.next();
		System.out.println("Enter final access period date: ");
		String finaldate = sc.next();
		
	}
	
	public void addStudent(String username, String gender, String nationality, String email, int auLimit, String matricnumber) {
		String password = "";
		Boolean admin = false;
		StudentAccount newstudent = new StudentAccount(username, password, admin, gender, nationality, email, auLimit, matricnumber);
		UserList.addAccount(newstudent);
		
		
		
	}
	
	public void addCourse(String coursecode, String courseName, int au) {
		Course newcourse = new Course( coursecode, courseName, au);
		CourseLinkList.addCourse(newcourse);
	}
	
	
	public void updateCourseIndex(Course mycourse, int oldindex, int newindex) {
		
		for (int i = 0; i< mycourse.getIndex.length(); i++)
		{			
			if (mycourse.getIndex().get(i).getIndex() == oldindex) //mycourse-> get arraylist of index-> get specific index-> get index name of index ==oldindex
			{
				mycourse.getIndex().get(i).setIndex(newindex); //mycourse->get arraylist of index-> get specific index-> set index name of index
			}
		}
		
	}
	
	public void updateCourseCode(Course mycourse, String newcoursecode) {
		mycourse.setCourseCode(newcoursecode);
			
	}
	
	
	public void printEnrollees(int number) {
		
		
		
		
		
		
	}
	
	public void printEnrollees(String courseCode) {
		for (int i = 0; i< CourseLinkList.size(); i++)
		{
			if (CourseLinkList.get(i).getCourseCode == courseCode)
			{
				Course mycourse = CourseLinkList.get(i);
				for (int j = 0; i < indexLinkedList.size(); j++) //How to call the specific index arraylist which is an attribute of course class?
				{
					if (indexLinkList.get(j).getIndex() == mycourse.getIndex())
					{
						for (int k = 0; k < RegisteredLinkList.size(); k++)
						{
							System.out.println("Name: " + RegisteredLinkList.get(k).getUserName());	//No name 
						}
					}

				}
					
			}
		}
	}
	
	
	
}
