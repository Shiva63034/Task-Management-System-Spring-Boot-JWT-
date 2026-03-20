package com.shiva.shiva.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private long id;
	
	@Column(name="taskname",nullable=false)
 private String taskname;
	
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="users_id")
	private User user;
	// Add this inside your Task.java class
	public void setUser(User user) {
	    this.user = user;
	}
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public User getUser() {
	    return user;
	}

	
}
