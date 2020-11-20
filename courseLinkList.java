package teamassignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class accountLinkList {
	
	private ArrayList<UserAccount> userlist;
	
	public accountLinkList() {
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
		return userlist;
	}
	
	public void addCourse(Course mycourse) {
		courseList.add(mycourse);
	}
	
	public void removeCourse(Course mycourse) {
		courseList.remove(mycourse);
	}
}
