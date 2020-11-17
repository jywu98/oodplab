package teamassignment;

import java.util.Scanner;

public class AdminAccount extends UserAccount{

	public AdminAccount() {
		super();
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
	
	public void updateCourse(Course mycourse, String coursecode) {

		//What is being changed? Is this set in the application class?
		//Assume change is coursecode
		mycourse.setCourseCode(coursecode);
		
	}
	
	public void updateCourse(Index myIndex, int index) {

		//What is being changed? Is this set in the application class?
		//Assume change is index
		myIndex.setIndex(index);
		
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
