package project;

import java.util.*;

public class Course {

	protected String courseCode;
	protected String courseName;
	protected int au;
	private ArrayList<Index> index;
	
	public Course(String courseCode, String courseName, int au, ArrayList<Index> index) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.au = au;
		this.index = index;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getAU() {
		return au;
	}
	
	public void setAU(int au) {
		this.au = au;
	}

	public ArrayList<Index> getIndex() {
		return index;
	}

	public void setIndex(ArrayList<Index> index) {
		this.index = index;
	}
	
	
}
