package com.app.tester;

import static com.app.util.TaskValidations.validateInputs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.task.StatusType;
import com.app.task.Task;
import com.app.util.TaskUtils;
import com.app.util.TaskValidations;
import com.app.utils.CompareByDate;

public class Tester {
	
	private static int id = 1;

	public static void main(String[] args)

	{
		// TODO Auto-generated method stu
		List<Task> task = new ArrayList<>();
		TaskUtils taskutil = new TaskUtils();
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit){
				System.out.println(
						"1.Add newTask\n 2.Display all task details\n 3.Delete a task\n 4.Update task status\n 5.Display all pending tasks\n"
								+ " 6.Display all pending tasks for today\n 7.Display all tasks sorted by taskDate\n 8.Exit");
				System.out.println("Enter your Choice");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter the taskName,description,taskDate,Active");
					Task addNewTask = validateInputs(id, sc.next(), sc.next(), sc.next(),"PENDING", sc.next());
					task.add(addNewTask);
					id++;
					break;

				case 2:
					System.out.println("Display all task details");
					for (Task taskdisplay : task) {
						System.out.println(taskdisplay);
					}
					break;

				case 3: System.out.println("Enter the TaskId ");
					TaskUtils.deleteTask(sc.nextInt(), task);
					System.out.println("Task Deleted Succesfully");
					break;

				case 4:
					System.out.println("Enter the taskId");
					Task taskUpdate = TaskValidations.validateId(sc.nextInt(), task);
					System.out.println(TaskUtils.updateStatus(taskUpdate, StatusType.valueOf(sc.next()), task));
					break;
				case 5:
					System.out.println("All Pending Task");
					TaskUtils.displayAllPendingTask(task);
					break;

				case 6:
					System.out.println("All Pending Task of Today");
					TaskUtils.displayAllPendingTaskofToday(task);
					break;

				case 7:
					Collections.sort(task, new CompareByDate());
					break;

				case 8:
					exit = true;

				}
			}

		} catch (TaskException e) {
			e.printStackTrace();
		}

	}

}
