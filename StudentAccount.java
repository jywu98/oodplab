package teamassignment;

import java.util.Scanner;

public class StudentAccount extends UserAccount{

	protected int auLimit;
	protected String matricnumber;
	protected Schedule schedule;
	
	public StudentAccount() {
		super(); auLimit = 24; matricnumber = "";
		Schedule schedule = new Schedule(matricnumber);
	}
	
	
	public StudentAccount(String username, String password, boolean admin, String name, String gender, String nationality, String email, int auLimit, String matricnumber)
	{
		super(username, password, admin, name, gender, nationality, email); this.auLimit = auLimit; this.matricnumber = matricnumber;
		Schedule schedule = new Schedule(matricnumber);
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
	
	
	public Boolean switchIndex(Index currentIndex, Index newIndex)
	{
		schedule.dropCourse(currentIndex);
		Boolean valid = schedule.addCourse(newIndex);
		if (valid == false){
			return false;
		}
		return true;
	}
	
	public Schedule getSchedule(){
		return this.schedule;
	}
	
	public void swapIndex(int index)
	{
	
	}
	
	
	
}
