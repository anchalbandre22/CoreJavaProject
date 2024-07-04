package com.app.task;
/*Create a menu driven application "TaskManager" to manage your day-to-day tasks. 

You can create a class Task with fields like taskId, taskName, description, taskDate, status, active. 
taskId should be unique and generated automatically.
status should be either PENDING, IN PROGRESS or COMPLETED.
active should be either true or false. Deleted task will have active=false 
Newly added task should have default status as PENDING and active=true

You can use suitable data structure to store data in memory.

Following functionalities are expected -

a. Add New Task                       
b. Delete a task                         
c. Update task status               
d. Display all pending tasks     
e. Display all pending tasks for today           
f.  Display all tasks sorted by taskDate      */

import java.time.LocalDate;
import java.util.Objects;

public class Task {
	private int taskId;
	private String taskName;
	private String description ;
	private LocalDate taskDate ;
	private StatusType status ;
	private ActiveType active ;
	
	public Task(int taskId , String taskName, String description, LocalDate taskDate, StatusType status, ActiveType active) {
		super();
		this.taskId=taskId;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status;
		this.active = active;
		
	}

	public Task(int id) {
		// TODO Auto-generated constructor stub
		this.taskId=id;
	}

	public Task(String string) {
		// TODO Auto-generated constructor stub
	}

	public  int getTaskId() {
		return taskId;
	}

	public  void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public ActiveType getActive() {
		return active;
	}

	public void setActive(ActiveType active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", taskDate="
				+ taskDate + ", status=" + status + ", active=" + active + "]";
	}

	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Task) {
			return this.taskId == ((Task) obj).getTaskId();
		}
		
		return false;
		
	}

	
	
	
	

}
