package com.shiva.shiva.service.serviceImpl;

import com.shiva.shiva.entity.Task;
import com.shiva.shiva.entity.User;
import com.shiva.shiva.exception.ApiException;
import com.shiva.shiva.exception.TaskNotFound;
import com.shiva.shiva.exception.UserNotFound;
import com.shiva.shiva.payload.TaskDto;
import com.shiva.shiva.repository.TaskRepository;
import com.shiva.shiva.repository.UserRepository;
import com.shiva.shiva.service.TaskService;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
@Service
public class TaskServiceImp implements TaskService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepository userRepository;
	@Autowired
   private TaskRepository taskRepository;
@Override
public TaskDto saveTask(long userid,TaskDto taskDto) {
	
	User user =userRepository.findById(userid).orElseThrow(
			()->new UserNotFound(String.format("User Id %d not found",userid))
			);
	Task task=modelMapper.map(taskDto,Task.class);
	task.setUser(user);;
	Task savedTask=taskRepository.save(task);
	//return modelMapper.map(savedTask,TaskDto.class);
	  TaskDto dto = new TaskDto();
	    dto.setId(savedTask.getId());
	    dto.setTaskname(savedTask.getTaskname());

	    return dto;
}
@Override
// Pass Task here

public List<TaskDto> getAllTasks(long userid){
	userRepository.findById(userid).orElseThrow(
			()->new UserNotFound(String.format("User Id %d not found",userid))
			);
	
	List<Task> tasks=taskRepository.findAllByUserId(userid);
	
	return tasks.stream().map(
			task ->modelMapper.map(task,TaskDto.class)
			).collect(Collectors.toList());
			


}
@Override
public TaskDto getTask(long userid, long taskid) {
	User users=userRepository.findById(userid).orElseThrow(
			()->new UserNotFound(String.format("User Id %d not found",userid))
			);
	Task task=taskRepository.findById(taskid).orElseThrow(
			() ->new TaskNotFound(String.format("Task Id %d not found",taskid))
			);
	if(users.getId()!=task.getUser().getId()) {
		
		throw new ApiException(String.format("Task ID %d is not belongs to User Id %d",taskid,userid));
	}
			
	return modelMapper.map(task,TaskDto.class);
}
@Override
public void deleteTask(long userid, long taskid) {
	// TODO Auto-generated method stub
	User users=userRepository.findById(userid).orElseThrow(
			()->new UserNotFound(String.format("User Id %d not found",userid))
			);
	Task task=taskRepository.findById(taskid).orElseThrow(
			() ->new TaskNotFound(String.format("Task Id %d not found",taskid))
			);
	if(users.getId()!=task.getUser().getId()) {
		
		throw new ApiException(String.format("Task ID %d is not belongs to User Id %d",taskid,userid));
	}
	taskRepository.deleteById(taskid);
	
}

}


