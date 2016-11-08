package edu.mum.hw2.domain;
import java.util.*;

import javax.persistence.*;
@Entity
public class Project {
	@Override
	public String toString() {
		return "Project [id=" + id + ", endDate=" + endDate + ", startDate=" + startDate + ", description="
				+ description + ", status=" + status + ", lBeneficiary=" + lBeneficiary + "]";
	}
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	private String description;
	private String status;
	@OneToMany
	@JoinColumn(name="p_id")
	private List<Beneficiary> lBeneficiary;
	public List<Beneficiary> getlBeneficiary() {
		return lBeneficiary;
	}
	public void setlBeneficiary(List<Beneficiary> lBeneficiary) {
		this.lBeneficiary = lBeneficiary;
	}
	public String getStatus(User u) {
		if(u.hasRole("listProject"))
			return status;
		else
		return null;
	}
	public void setStatus(String status, User u) {
		if(u.hasRole("createProject"))
			this.status = status;
	}
	@OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	private List<Task> lTask;
	private Project() {
		
	}
	public static Project getInstance(User u) {
		if(u.hasRole("createProject"))
			return new Project();
		else return null;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((lBeneficiary == null) ? 0 : lBeneficiary.hashCode());
		result = prime * result + ((lTask == null) ? 0 : lTask.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Project other = (Project) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (lBeneficiary == null) {
			if (other.lBeneficiary != null)
				return false;
		} else if (!lBeneficiary.equals(other.lBeneficiary))
			return false;
		if (lTask == null) {
			if (other.lTask != null)
				return false;
		} else if (!lTask.equals(other.lTask))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	public Date getEndDate(User u) {
		if(u.hasRole("listProject"))
			return endDate;
		else return null;
	}
	public void setEndDate(Date endDate, User u) {
		if(u.hasRole("createProject"))
			this.endDate = endDate;
	}
	public Date getStartDate(User u) {
		if(u.hasRole("listProject"))
			return startDate;
		else return null;
	}
	public void setStartDate(Date startDate, User u) {
		if(u.hasRole("createProject"))
			this.startDate = startDate;
	}
	public String getDescription(User u) {
		if(u.hasRole("listProject"))
			return description;
		else return null;
	}
	public void setDescription(String description, User u) {
		if(u.hasRole("createProject"))
			this.description = description;
	}
	public List<Task> getlTask(User u) {
		if(u.hasRole("listTask"))
			return lTask;
		else return null;
	}
	public void setlTask(List<Task> lTask, User u) {
		if(u.hasRole("createProject")) {
			this.lTask = lTask;
		}
	}
}