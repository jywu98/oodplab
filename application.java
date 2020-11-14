package teamassignment;

import java.util.Scanner;

public class application {
	
	public static boolean authenticatePassword(UserAccount user, String password) {
		if (user.getPassword() == password)
			return true;
		else
			return false;
	}
	
	public static String promptUsername() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username = sc.next();
		return username;
	}
	
	public static String promptPassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Password: ");
		String password = sc.next();
		return password;
	}
	
	public static UserAccount findUser(String username) {
		for (int i=0; i<UserList.size(); i++) {
			if (UserList.get(i).getUsername == username) {
				return UserList.get(i);
			}
		}
    }
	
	public static void main(String[] args) {
			
		String username = promptUsername();
		UserAccount myUser = findUser(username);
		
		String password = promptPassword();
		int count = 3;
		while (authenicatePassword(myUser, password) == false) {
			count--;
			if (count == 0)
				System.out.println("Exiting Program...");
				java.lang.System.exit(0);
			System.out.println("You have entered a wrong password! You have " + count + " tries remaining.");	
		}
		
		if (myUser.isAdmin()) {
			System.out.println("==============Welcome to=============");
			System.out.println("============Admin Account============");
			System.out.println("|1. Edit Access Period              |");
			System.out.println("|2. Add Student                     |");
			System.out.println("|3. Add Course                      |");
			System.out.println("|4. Update Course                   |");
			System.out.println("|5. Print Enrollees by Index        |");
			System.out.println("|6. Print Enrollees by Course       |");
			System.out.println("|7. Quit                            |");
			System.out.println("=====================================");
		}
		else {
			System.out.println("==============Welcome to=============");
			System.out.println("===========Student Account===========");
			System.out.println("|1. Check Courses                   |");
			System.out.println("|2. Change Index                    |");
			System.out.println("|3. Swap Index                      |");
			System.out.println("|4. Quit                            |");
			System.out.println("=====================================");
		}
	}

}
