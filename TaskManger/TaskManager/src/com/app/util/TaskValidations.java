package com.app.util;

import java.time.LocalDate;
import java.util.List;

import com.app.task.ActiveType;
import com.app.task.StatusType;
import com.app.task.Task;
import com.app.tester.TaskException;

public class TaskValidations {
	
	
	public static Task validateInputs(int taskId , String taskName, String description, String TaskDate, String status, String active){
		LocalDate taskDate = parseString(TaskDate);
		StatusType Status = parseStringtoStatus(status.toUpperCase());
		ActiveType Active = parseStringtoActive(active.toUpperCase());
		
		return new Task(taskId,taskName,description,taskDate,Status,Active);
		
	}
	
	
	public static LocalDate parseString(String TaskDate) {
		return LocalDate.parse(TaskDate);
		
		
	}
	
	public static StatusType parseStringtoStatus(String status) {
		return StatusType.valueOf(status);
		
		
	}
	public static ActiveType parseStringtoActive(String active) {
		return ActiveType.valueOf(active);
		
		
	}
	public static Task validateId(int id,List<Task> task)throws TaskException {
		 Task task1 = new Task(id);
		 if(task.contains(task1)) {
			 return task1;
		 }
		
		 throw new TaskException("No Such Task Found");
		
	}
}
