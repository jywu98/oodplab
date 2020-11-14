package teamassignment;

import java.util.Scanner;

public class UserAccount {

	private String username;
	private String password;
	private boolean admin;
	private String gender;
	private String nationality;
	private String email;
	
	
	public UserAccount(String username, String password, boolean admin, String gender, String nationality, String email) {
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.gender = gender;
		this.nationality = nationality;
		this.email = email;
	}

	public UserAccount() {
		this.username = "";
		this.password = "";
		this.admin = false;
		this.gender = "";
		this.nationality = "";
		this.email = "";
	}

	public boolean isAdmin() {
		if (admin)
			return true;
		else
			return false;
	}

	
	public int checkVacancies(int number) {
		if (getCourse(number).getVacancy()<=0)
		{
			System.out.println("There are no vacancies for this course.");
		}
		else
		{
			
		}
	}
	
	public String getPassword() {
		return this.password;
	}	
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
}
