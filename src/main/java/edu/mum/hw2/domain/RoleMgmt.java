package edu.mum.hw2.domain;
import java.util.*;
public class RoleMgmt {
	static public HashMap<String, List<String>> roleAccess = new HashMap<String, List<String>>();
	static {
		roleAccess.put(Role.VOLUNTEER.toString(), Arrays.asList(new String[] {"serveTask", "listProject", "listBeneficiary", "listTask"}));
	}

	public Role getRole(User u) {
		return u.getRole();
	}
	
	public boolean hasRole(User u, String activity) {
		System.out.println(u.getRole());
		System.out.println("fff");
		if(u.getRole().equals("ADMIN")){
			System.out.println("fuck");
			return true;
		} else
			return roleAccess.get(u.getRole().toString()).contains(activity) ? true : false;
	}

}
