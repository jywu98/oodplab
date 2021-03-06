package teamassignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class courseLinkList {
	
	private ArrayList<Course> courseList;
	
	public courseLinkList() {
		this.courseList = new ArrayList<Course>();
	}
	
	public void createCourselist() throws Exception 
		{
	        try
	        {
	            FileInputStream fis = new FileInputStream("courseData");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	 
	            courseList = (ArrayList) ois.readObject();
	 
	            ois.close();
	            fis.close();
	            
	        } 
	        catch (IOException e) 
	        {
	            System.out.println(e.getMessage());
	        } 
		}
	public ArrayList<Course> getCourseList(){
		return courseList;
	}
	//Method doesnt work if getcoursecode != coursecode
	//public Course findCourse(String coursecode){
	//	for (int i = 0; i < courseList.size(); i++){
	//		if (courseList.get(i).getCourseCode() == coursecode){
	//			return courseList.get(i)
	//		}
	//	}
	//	System.out.println("Error - invalid course code!");
	//}
	
	public void addCourse(Course mycourse) {
		courseList.add(mycourse);
	}
	
	public void removeCourse(Course mycourse) {
		courseList.remove(mycourse);
	}
}
