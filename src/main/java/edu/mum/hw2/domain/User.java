package edu.mum.hw2.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Enumerated(EnumType.STRING)
	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role != other.role)
			return false;
		return true;
	}



	static public HashMap<String, List<String>> roleAccess = new HashMap<String, List<String>>();
	static {
		roleAccess.put(Role.VOLUNTEER.toString(), Arrays.asList(new String[] {"serveTask", "listProject", "listBeneficiary", "listTask"}));
		roleAccess.put(Role.ADMIN.toString(), Arrays.asList(new String[] {"createTask", "createProject", "updateTask", "addResource"}));
	}

	
	public boolean hasRole(String activity) {
		if(this.getRole().toString().equals("ADMIN")){
			return true;
		}
		return roleAccess.get(this.getRole().toString()).contains(activity) ? true : false;
	}

}
