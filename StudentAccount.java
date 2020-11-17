package teamassignment;

import java.util.Scanner;

public class StudentAccount extends UserAccount{

	protected int auLimit;
	protected String matricnumber;
	
	public StudentAccount() {
		super(); auLimit = 24; matricnumber = "";
	}
	
	
	public StudentAccount(String username, String password, boolean admin, String gender, String nationality, String email, int auLimit, String matricnumber)
	{
		super(username, password, admin, gender, nationality, email); this.auLimit = auLimit; this.matricnumber = matricnumber;
	}
	
	public void checkCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course code: ");
		String coursecode = sc.next();
		for (int i = 0; i< courseLinkList.size(); i++)
		{
			if (courseLinkList.get(i) == coursecode)
			{
				System.out.println("Course Code: " + coursecode);
				for (int j = 0; j< IndexLinklist.size(); j++)
				{
					System.out.println("Index :" + IndexLinkList.get(j).getIndex()	);
				}
				
			}
		}
	}
	
	
	public void switchIndex(String courseCode)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter coursecode you wish to switch to: ");
		
	}
	
	public void swapIndex(int index)
	{
		
	}
	
	
	
}
