import java.util.Scanner;

public class StudentAccount{
	private Student student;
	private ArrayList<School> schoollist;
	
	public StudentAccount(Student student, ArrayList<School> schoollist){
		this.student = student;
		this.schoollist = schoollist;
	}	
	
	public boolean printMenu(){
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("==============Welcome to=============");
			System.out.println("===========Student Account===========");
			System.out.println("|1. Add Course                      |");
			System.out.println("|2. Drop Course                     |");
			System.out.println("|3. Check/Print Courses Registered  |");
			System.out.println("|4. Check Vacancies Available       |");
			System.out.println("|5. Change Index of Course          |");
			System.out.println("|6. Swap Index with another Student |");
			System.out.println("|7. Log out                         |");
			System.out.println("=====================================");
			System.out.println("Choose option (1-7): ");
			choice = sc.nextInt();
			
			case(choice){
				case 1:
					this.addCourse();
					break;
				case 2:
					this.dropCourse();
					break;
				case 3:
					this.checkCourse();
					break;
				case 4:
					this.checkVacancies();
					break;
				case 5:
					this.changeIndex();
					break;
				case 6:
					this.swapIndex();
					break;
			}
		} while (choice < 7);
		
		System.out.println("Logging out...");
		System.out.println("Thank you for using STARS Planner!");
		sc.close();
		return false;
	}
	
	public void addCourse(){
		for (int i = 0; i < schoollist.size(); i++){
			if (schoollist.get(i).getSchoolname().equals(this.student.getSchool())){
				School mySchool = schoollist.get(i);
			}	
		}
		
		mySchool.printCourselist();
		ArrayList<Course> courselist = mySchool.getCourselist();
		System.out.println("Please enter the course code you wish to add: ");
		Scanner sc = new Scanner(System.in);
		String coursecode = sc.next();
		
		for (int i = 0; i < courselist.size(); i++){
			if (courselist.get(i).getCourseCode().equals(coursecode)){
				Course chosen = courselist.get(i);
				break;
			}
		}
		
		chosen.printIndexlist();
		ArrayList<Index> indexlist = chosen.getIndexlist();
		System.out.println("Please enter the index you wish to add: ");
		int index_ = sc.nextInt();
		
		for (int i = 0; i < indexlist.size(); i++){
			if (indexlist.get(i).getIndex().equals(index_)){
				Index selected = indexlist.get(i);
				break;
			}
		}
		
		if (selected.checkVacancies() <= 0){
			System.out.println("The index you have chosen currently as no vacancies.");
			System.out.println("1. Add to your waitlist");
			System.out.println("2. Exit to main menu");
			System.out.println("Choose option (1-2): ");
			int choice = sc.nextInt();
			if (choice >= 2){
				System.out.println("Exiting to main menu...");
				return;
			}
			select.waitStudent(this.student);
			student.getSchedule().wait(selected);
			System.out.println("Successfully added " + selected.getIndex() + " to your waitlist.");
			return;
		}
		
		boolean success = student.getSchedule().addCourse(selected);
		if (!success){
			return;
		}
		selected.registerStudent(this.student);
		System.out.println("Successfully registered for " + selected.getIndex() + ".");
		return;
	}
	
	public void dropCourse(){
		ArrayList<Index> registered = this.student.getSchedule().getRegistered();
		ArrayList<Index> waiting = this.student.getSchedule().getWaiting();
		System.out.println("Currently chosen courses: ");
		for (int i = 0; i < registered.size(); i++){
			Index current = registered.get(i);
			System.out.println(current.getCourseCode() + " " + current.getIndex() + " Registered");
		}
		for (int i = 0; i < waiting.size(); i++){
			Index current = waiting.get(i);
			System.out.println(current.getCourseCode() + " " + current.getIndex() + " On Waitlist");
		}
		System.out.println("Please enter the index you wish to drop: ");
		Scanner sc = new Scanner(System.in);
		int drop = sc.nextInt();
		for (int i = 0; i < registered.size(); i++){
			if (registered.get(i).getIndex() == drop){
				Index index_ = registered.get(i);
				index_.dropStudent(this.student);
				student.getSchedule().dropCourse(index_);
				System.out.println("Successfully dropped " + index_.getIndex() + ".");
				return;
			}
		}
		for (int i = 0; i < waiting.size(); i++){
			if (waiting.get(i).getIndex() == drop){
				Index index_ = waiting.get(i);
				index_.unwaitStudent(this.student);
				student.getSchedule().unwait(index_);
				System.out.println("Successfully dropped " + index_.getIndex() + ".");
				return;
			}
		}
	}
	
	public void checkCourse(){
		ArrayList<Index> courses = student.getSchedule().getRegistered();
		for (int i = 0; i < course.size(); i++){
			Index current = course.get(i);
			println(current.getCourseCode() + ", " /*+ current.getCourse().getAU() + " AU, "*/ + current.getIndex() + ", Registered");
		}
		ArrayList<Index> waitlist = student.getSchedule().getWaiting();
		for (int i = 0; i < waitlist.size(); i++){
			Index current = waitlist.get(i);
			println(current.getCourseCode() + ", " /*+ current.getCourse().getAU() + " AU, "*/ + current.getIndex() + ", Waitlist");
		}
		return;
	}
	
	public void checkVacancies(){
		for (int i = 0; i < schoollist.size(); i++){
			if (schoollist.get(i).getSchoolname().equals(this.student.getSchool())){
				School mySchool = schoollist.get(i);
			}	
		}
		
		mySchool.printCourselist();
		ArrayList<Course> courselist = mySchool.getCourselist();
		System.out.println("Please enter the course to check: ");
		Scanner sc = new Scanner(System.in);
		String coursecode = sc.next();
		
		for (int i = 0; i < courselist.size(); i++){
			if (courselist.get(i).getCourseCode().equals(coursecode)){
				Course chosen = courselist.get(i);
				break;
			}
		}
		
		chosen.printIndexlist();
		ArrayList<Index> indexlist = chosen.getIndexlist();
		System.out.println("Please enter the index to check: ");
		int index_ = sc.nextInt();
		
		for (int i = 0; i < indexlist.size(); i++){
			if (indexlist.get(i).getIndex().equals(index_)){
				Index selected = indexlist.get(i);
				break;
			}
		}
		
		System.out.println(select + ": " + selected.getVacancies() + " vacancies");
		return;
	}
	
	public void changeIndex(){
		ArrayList<Index> registered = this.student.getSchedule().getRegistered();
		System.out.println("Currently registered courses: ");
		for (int i = 0; i < registered.size(); i++){
			Index current = registered.get(i);
			System.out.println(current.getCourseCode() + " " + current.getIndex() + " Registered");
		}
		System.out.println("Please enter the index you wish to change: ");
		Scanner sc = new Scanner(System.in);
		int change = sc.nextInt();
		for (int i = 0; i < registered.size(); i++){
			if (registered.get(i).getIndex() == change){
				Index current = registered.get(i);
				break;
			}
		}
		for (int i = 0; i < schoollist.size(); i++){
			if (schoollist.get(i).getSchoolname().equals(this.student.getSchool())){
				School mySchool = schoollist.get(i);
			}	
		}
		ArrayList<Course> courselist = mySchool.getCourselist();
		for (int i = 0; i < courselist.size(); i++){
			if (courselist.get(i).getCourseCode().equals(current.getCourseCode())){
				Course chosen = courselist.get(i);
				break;
			}
		}
		System.out.println("Available indexes for course: ");
		chosen.printIndexlist();
		ArrayList<Index> indexlist = chosen.getIndexlist();
		System.out.println("Please enter the index you wish to change to: ");
		int index_ = sc.nextInt();
		for (int i = 0; i < indexlist.size(); i++){
			if (indexlist.get(i).getIndex().equals(index_)){
				Index selected = indexlist.get(i);
				break;
			}
		}
		if (selected.getVacancies() <= 0){
			System.out.println("Error - Index entered is already full");
			return;
		}
		System.out.println("Please confirm the change in index for " + coursecode + ": ");
		System.out.println("Current index: ");
		current.printDetails();
		System.out.println("New index: ");
		selected.printDetails();
		System.out.println("1. Confirm change");
		System.out.println("2. Cancel");
		int choice = sc.nextInt();
		if (choice >= 2){
			return;
		}
		Boolean valid = this.student.switchIndex(current, selected);
		if (valid == false){
			return;
		}
		current.dropStudent(myUser);
		new.registerStudent(myUser);
		System.out.println("Successfully changed " + currentIndex.getIndex() + " to " + newIndex.getIndex());
	}	
}
