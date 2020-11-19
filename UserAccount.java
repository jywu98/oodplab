package teamassignment;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserAccount implements Serializable{

	private String username;
	private String password;
	private boolean admin;
	private String name;
	private String gender;
	private String nationality;
	private String email;
	
	
	public UserAccount(String username, String password, boolean admin, String name, String gender, String nationality, String email) {
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.name = name;
		this.gender = gender;
		this.nationality = nationality;
		this.email = email;
	}

	public UserAccount() {
		this.username = "";
		this.password = "";
		this.admin = false;
		this.name = "";
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
		for (int i = 0; i< indexList.size(); i++)
		{
			if (indexList.get(i).getIndex == number)
			{
				return indexList.get(i).getVacancies;
			}
		}
	
	}
	
	public Boolean authenticatePassword(String password) throws NoSuchAlgorithmException {
		hashing hashtool = new hashing();
		if (this.password.equals(hashtool.getHash(password)))
		{
			return true;
		}
		return false;
	}	
	
	public String getUsername() {
		return this.username;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public String getNationality() {
		return this.nationality;
	}
	
	public String getUsername() {
		return this.username;
	}
	
}
