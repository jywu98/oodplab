package teamassignment;

import java.util.ArrayList;

public class accountLinkList {
	
	ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
	
	public void addAccount(UserAccount user) {
		accounts.add(user);
	}
	
	public void removeAccount(UserAccount user) {
		accounts.remove(user);
	}
}
