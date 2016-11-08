package edu.mum.hw2.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;
@Entity
public class User {
	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	static public HashMap<String, List<String>> roleAccess = new HashMap<String, List<String>>();
	static {
		roleAccess.put(Role.VOLUNTEER.toString(), Arrays.asList(new String[] {"serveTask", "listProject", "listBeneficiary"}));
		roleAccess.put(Role.ADMIN.toString(), Arrays.asList(new String[] {"createTask", "createProject", "updateTask", "addResource"}));
	}

	
	public boolean hasRole(String activity) {
		return roleAccess.get(this.getRole().toString()).contains(activity) ? true : false;
	}

}
