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
