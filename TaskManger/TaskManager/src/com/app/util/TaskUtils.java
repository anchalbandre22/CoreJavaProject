package com.app.util;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import com.app.task.StatusType;
import com.app.task.Task;

public class TaskUtils {

	public static void deleteTask(int id, List<Task> task) {
		Iterator<Task> itr = task.iterator();
		while (itr.hasNext()) {
			Task t = itr.next();
			if (t.getTaskId() == id) {
				itr.remove();
			}
		}

	}

	public static String updateStatus(Task updatetask, StatusType Status, List<Task> task) {
		int index = task.indexOf(updatetask);
		Task t = task.get(index);
		t.setStatus(Status);
		return "Task Update Succesfully";

	}

	public static void displayAllPendingTask(List<Task> task) {
		for (Task t : task) {
			if (t.getStatus() == StatusType.PENDING) {
				System.out.println(t);
			}
		}
	}

	public static void displayAllPendingTaskofToday(List<Task> task) {
		LocalDate today = LocalDate.now();
		for (Task t : task) {
			if (t.getStatus() == StatusType.PENDING && t.getTaskDate().equals(today)) {
				System.out.println(t); 
			}
		}

	}

	
  	
	
	
	
}
