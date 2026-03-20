package com.shiva.shiva.service;
//import java.util.List;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shiva.shiva.payload.TaskDto;


public interface TaskService {
       public TaskDto saveTask(long userid,TaskDto taskDto);
    //   public List<TaskDto> getAllTasks(long userid);
   //    public TaskDto getTask(long userid,long todoid);

	   List<TaskDto> getAllTasks(long userid);
	   public TaskDto getTask(long userid,long taskid);
	   public void deleteTask(long userid,long taskid);
}
