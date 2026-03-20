package com.shiva.shiva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shiva.shiva.entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

	List<Task> findAllByUserId(long userid);  

}
