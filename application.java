package teamassignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class accountLinkList {
	
	private ArrayList<UserAccount> userlist;
	
	public accountLinkList() {
		this.userlist = new ArrayList<UserAccount>();
	}
	
	public void createUserlist() throws Exception 
		{
	        try
	        {
	            FileInputStream fis = new FileInputStream("userData");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	 
	            userlist = (ArrayList) ois.readObject();
	 
	            ois.close();
	            fis.close();
	            
	        } 
	        catch (IOException e) 
	        {
	            System.out.println(e.getMessage());
	        } 
		}
	public ArrayList<UserAccount> getUserlist(){
		return userlist;
	}
	
	public void addAccount(UserAccount user) {
		userlist.add(user);
	}
	
	public void removeAccount(UserAccount user) {
		userlist.remove(user);
	}
}
