package com.omernaci.opentask.controller;

import com.omernaci.opentask.dto.request.CreateTaskRequest;
import com.omernaci.opentask.dto.response.BaseApiResponse;
import com.omernaci.opentask.dto.response.TaskListResponse;
import com.omernaci.opentask.dto.response.TaskResponse;
import com.omernaci.opentask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = {"/api/v1/tasks"}, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins="http://localhost:4200")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseApiResponse> createTask(@Valid @RequestBody CreateTaskRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(request));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BaseApiResponse> deleteTask(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.deleteTask(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTask(id));
    }

    @GetMapping
    public ResponseEntity<TaskListResponse> getTaskList() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable(name = "id") Long id,
                                                   @Valid @RequestBody CreateTaskRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(id, request));
    }

}
