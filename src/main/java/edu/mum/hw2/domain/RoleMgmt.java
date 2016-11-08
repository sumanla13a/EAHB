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
		if(u.getRole().equals(Role.ADMIN)) return true;
		return roleAccess.get(u.getRole().toString()).contains(activity) ? true : false;
	}

}
