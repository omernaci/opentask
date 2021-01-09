package com.omernaci.opentask.service.impl;

import com.omernaci.opentask.domain.Task;
import com.omernaci.opentask.dto.TaskDto;
import com.omernaci.opentask.dto.request.CreateTaskRequest;
import com.omernaci.opentask.dto.response.BaseApiResponse;
import com.omernaci.opentask.dto.response.TaskListResponse;
import com.omernaci.opentask.dto.response.TaskResponse;
import com.omernaci.opentask.repository.TaskRepository;
import com.omernaci.opentask.service.TaskService;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public BaseApiResponse createTask(CreateTaskRequest request) {

        Task task = new Task();
        task.setName(request.getName());
        task.setNotes(request.getNotes());
        task.setStartDate(new Date());
        task.setDueDate(request.getDueDate());
        task.setPriority(request.getPriority());

        taskRepository.save(task);

        return new BaseApiResponse(true, "success");
    }

    @Override
    public BaseApiResponse deleteTask(Long id) {
        BaseApiResponse response = new BaseApiResponse();

        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            taskRepository.delete(taskOptional.get());
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
        }

        return response;
    }

    @Override
    public TaskResponse getTask(Long id) {
        TaskResponse response = new TaskResponse();
        ModelMapper mapper = new ModelMapper();

        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            response.setTaskDto(mapper.map(taskOptional.get(), TaskDto.class));
            response.setSuccess(true);
        } else {
            handleApiException(response);
        }

        return response;
    }

    @Override
    public TaskListResponse getTaskList() {
        TaskListResponse response = new TaskListResponse();
        List<Task> tasks = taskRepository.findAll();

        if (CollectionUtils.isNotEmpty(tasks)) {
            Type listType = new TypeToken<List<TaskDto>>() {}.getType();
            response.setTaskDtos(new ModelMapper().map(tasks, listType));
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
        }

        return response;
    }

    @Override
    public TaskResponse updateTask(Long id, CreateTaskRequest request) {
        TaskResponse response = new TaskResponse();

        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setName(request.getName());
            task.setNotes(request.getNotes());
            task.setStartDate(request.getStartDate());
            task.setDueDate(request.getDueDate());
            task.setPriority(request.getPriority());

            Task updatedTask = taskRepository.save(task);

            response.setTaskDto(new ModelMapper().map(updatedTask, TaskDto.class));
            response.setSuccess(true);
        } else {
            response.setSuccess(false);
        }

        return response;
    }

    private void handleApiException(TaskResponse response) {
        response.setSuccess(false);
    }
}
