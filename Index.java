package project;

import java.util.ArrayList;

public class Index {
	protected Course course;
	protected int index;
	protected int classLimit;
	protected ArrayList<Lesson> indexLessons;
	protected ArrayList<StudentAccount> registeredStudents;
	protected ArrayList<StudentAccount> waitlist;
	
	public Index(Course course, int index, int classLimit) {
		this.course = course;
		this.index = index;
		this.classLimit = classLimit;
		indexLessons = new ArrayList<Lesson>();
		registeredStudents = new ArrayList<StudentAccount>();
		waitlist = new ArrayList<StudentAccount>();
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getClassLimit() {
		return classLimit;
	}

	public void setClassLimit(int classLimit) {
		this.classLimit = classLimit;
	}
	
	public ArrayList<Lesson> getLessons(){
		return indexLessons;
	}
	
	public void addLesson(Lesson lesson){
		indexLessons.add(lesson);
	}	
	
	public int getVacancies(){
		return classLimit - registeredStudents.size();
	}
	
	public void registerStudent(StudentAccount student){
		registeredStudents.add(student);
	}
	
	public void dropStudent(StudentAccount student){
		registeredStudents.remove(student);
		if (waitlist.size() > 0){
			StudentAccount newstudent = waitlist.get(0);
			registeredStudents.add(newstudent);
			waitlist.remove(newstudent);
			/* send email notif here */
		}
	}
	
	public void waitStudent(StudentAccount student){
		waitlist.add(student);
	}
	
	public void unwaitStudent(StudentAccount student){
		waitlist.remove(student);
	}
	
	public int getWaitlistLength(){
		return waitlist.size();
	}
	
	public void swapStudent(StudentAccount add, StudentAccount drop){
		registeredStudents.remove(drop);
		registeredStudents.add(add);
	}
	
	public void printEnrollees(){
		for (int i = 0; i < registeredStudents.size(); i++){
			StudentAccount current = registeredStudents.get(i);
			System.out.println(current.getName() + ", " + current.getGender() + ", " + current.getNationality());
		}	
	}	
}
