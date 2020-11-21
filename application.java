package teamassignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class application {
	
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
	
	public static UserAccount findUser(accountLinkList userlist) {
		
		String username = promptUsername();
		boolean match = false;
		UserAccount myUser = new UserAccount();
		
		while (match == false) {
			for (int i=0; i<userlist.getUserlist().size(); i++) {
				if (userlist.getUserlist().get(i).getUsername().equals(username)) {
					System.out.println("Success!");
					match = true;
					myUser = userlist.getUserlist().get(i);
					break;
				}
			System.out.println("No such user found. Please try again.");
			username = promptUsername();
			}
		}
		return myUser;
	}
	
	public static void main(String[] args) throws Exception {
		
		accountLinkList userlist = new accountLinkList();
		userlist.createUserlist();
		courseLinkList courselist = new courseLinkList();
		courselist.createCourselist();
		IndexMasterList indexlist = new IndexMasterList();
		int choice;
		int choice2;
		Scanner sc = new Scanner(System.in);
	
		do {
			System.out.println("=============Welcome to==============");
			System.out.println("===========Stars Planner=============");
			System.out.println("|1. Log in                          |");
			System.out.println("|2. Check current time and date     |");
			System.out.println("|3. Quit                            |");
			System.out.println("=====================================");
			
			System.out.println("Choose option (1-3):        ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					UserAccount myUser = findUser(userlist);
					String password = promptPassword();
					int count = 3;
					while (myUser.authenticatePassword(password) == false) {
						count--;
						if (count == 0) {
							System.out.println("Exiting Program...");
							java.lang.System.exit(0);
						}
						System.out.println("You have entered an invalid password! You have " + count + " tries remaining.");
						password = promptPassword();
					}
					System.out.println("Success!");
					if (myUser.isAdmin()) {
						do {
							System.out.println("==============Welcome to=============");
							System.out.println("============Admin Account============");
							System.out.println("|1. Edit Access Period              |");
							System.out.println("|2. Add Student                     |");
							System.out.println("|3. Add Course                      |");
							System.out.println("|4. Update Course	                |");
							System.out.println("|5. Print Enrollees by Index        |");
							System.out.println("|6. Print Enrollees by Course       |");
							System.out.println("|7. Log out                         |");
							System.out.println("=====================================");
							
							System.out.println("Choose option (1-7):        ");
							choice2 = sc.nextInt();
							
							switch(choice2) {
							case 2:
								hashing hashtool = new hashing();
								StudentAccount student = new StudentAccount("test", hashtool.getHash("password"), false, "noname", "Male", "ai", "test@ntu.edu.sg", 99, "U2323233Z");
								userlist.addAccount(student);
								break;
							case 3:
								Course mycourse = new Course("BC2406", "Hello There", 3);
								courselist.addCourse(mycourse);
								break;
								
								
							case 4:
								System.out.println("Enter coursecode: ");
								String mycoursecode = sc.next();
								System.out.println("Enter old index: ");
								int oldindex =  sc.nextInt();
								System.out.println("Enter new index: ");
								int newindex = sc.nextInt();
								((AdminAccount) myUser).updateCourseIndex(courselist, mycoursecode, oldindex, newindex);
								break;
							}
						}	
						while (choice2 < 7);
					}
					else {
						do {
						System.out.println("==============Welcome to=============");
						System.out.println("===========Student Account===========");
						System.out.println("|1. Check Courses                   |");
						System.out.println("|2. Change Index                    |");
						System.out.println("|3. Swap Index                      |");
						System.out.println("|4. Log out                         |");
						System.out.println("=====================================");
						
						System.out.println("Choose option (1-4):        ");
						choice2 = sc.nextInt();
						
						switch(choice2) {
							case 1:
								ArrayList<Index> courses = myUser.getSchedule().getRegistered();
								for (int i = 0; i < course.size(); i++){
									Index current = course.get(i);
									println(current.getCourse().getCourseCode() + ", " + current.getCourse().getAU() + " AU, " + current.getIndex() + ", Registered");
								}
								ArrayList<Index> waitlist = myUser.getSchedule().getWaiting();
								for (int i = 0; i < waitlist.size(); i++){
									Index current = waitlist.get(i);
									println(current.getCourse().getCourseCode() + ", " + current.getCourse().getAU() + " AU, " + current.getIndex() + ", Waitlist");
								}
								break;
							case 2:
								System.out.println("Enter your current index number: ");
								int current = sc.nextInt();
								Index currentIndex = indexlist.getIndex(current);
								String coursecode = currentIndex.getCourse().getCourseCode();
								System.out.println("Enter index number you would like to change to: ");
								int new_ = sc.nextInt();
								Index newIndex = indexlist.getIndex(new_);
								if (newIndex.getCourse().getCourseCode() != coursecode){
									System.out.println("Error - Index entered is not from the same course");
									break;
								}
								if (newIndex.getVacancies() <= 0){
									System.out.println("Error - Index entered is already full");
									break;
								}	
								System.out.println("Please confirm the change in index for " + coursecode + ": ");
								System.out.println("Current index: ");
								currentIndex.printDetails();
								System.out.println("New index: ");
								newIndex.printDetails();
								System.out.println("1. Confirm change");
								System.out.println("2. Cancel");
								int choice3 = sc.nextInt();
								if (choice3 == 2){
									break;
								}
								Boolean valid = myUser.switchIndex(currentIndex, newIndex);
								if (valid == false){
									break;
								}
								currentIndex.dropStudent(myUser);
								newIndex.registerStudent(myUser);
								System.out.println("Successfully changed " + currentIndex.getIndex() + " to " + newIndex.getIndex());
								break;
							case 3:
								System.out.println("Enter your current index number: ");
								int current = sc.nextInt();
								Index currentIndex = indexlist.getIndex(current);
								System.out.println("Enter your friend's index number: ");
								int new_ = sc.nextInt();
								Index newIndex = indexlist.getIndex(new_);
								if (newIndex.course.getCourseCode() != coursecode){
									System.out.println("Error - Index entered is not from the same course");
									break;
								}
								System.out.println("Please enter your friend's login details: ");
								UserAccount friend = findUser(userlist);
								String password = promptPassword();
								if (friend.authenticatePassword(password) == false){
									System.out.println("Error - invalid password");
									break;
								}
								ArrayList<Index> friendcourses = friend.getSchedule().getRegistered();
								boolean error = false;
								for (int i = 0; i < friendcourses.size(); i++){
									if (friendcourses.get(i) == newIndex){
										break;
									}
									error = true;
								}
								if (error){
									System.out.println("Error - friend does not take selected index");
									break;
								}
								Boolean uservalid = myUser.switchIndex(current, newIndex);
								if (uservalid == false){
									break;
								}
								Boolean friendvalid = friend.switchIndex(newIndex, current);
								if (friendvalid == false){
									uservalid = myUser.switchIndex(newIndex, current);
									break;
								}
								current.swapStudent(friend, myUser);
								newIndex.swapStudent(myUser, friend);
								System.out.println("Successfully swapped index");
								break;
						}
						}
						while (choice2 < 4);
					}
					break;
				case 2:
				   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				   LocalDateTime now = LocalDateTime.now();  
				   System.out.println(dtf.format(now));  
				   break;
			}
		} 
		while(choice < 3);
		
		System.out.print("Thank you for using Stars Planner!");
	}
		
}
