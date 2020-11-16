package project;

import java.util.ArrayList;

public class Course {

	protected String courseCode;
	protected String courseName;
	protected int au;
	protected ArrayList<Index> courseIndex;
	
	public Course(String courseCode, String courseName, int au) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.au = au;
		courseIndex = new ArrayList<Index>();
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
		return courseIndex;
	}
	
	public void addIndex(Index index_){
		courseIndex.add(index_);
	}	
}
