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
	
	public void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student username:");
		String username = sc.next();
		System.out.println("Enter Student password: ");
		String password = sc.next();
		
		
		
	}
	
	public void addCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course code:");
		String coursecode = sc.next();
	}
	
	public void updateCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course code: ");
		String coursecode = sc.next();
		
	}
	
	public void printEnrollees(int number) {
		int head = x;
		while (head!= null)
		{
			System.out.println(head.key);
			head = head.next();
		}
	}
	
	public void printEnrollees(String courseCode) {
		int head = x;
		while (head!= null)
		{
			System.out.println(head.key);
			head = head.next();
		}
	}
	
	
	
}
