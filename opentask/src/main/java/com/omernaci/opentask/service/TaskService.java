package com.omernaci.opentask.service;

import com.omernaci.opentask.dto.request.CreateTaskRequest;
import com.omernaci.opentask.dto.response.BaseApiResponse;
import com.omernaci.opentask.dto.response.TaskListResponse;
import com.omernaci.opentask.dto.response.TaskResponse;

public interface TaskService {

    BaseApiResponse createTask(CreateTaskRequest request);

    BaseApiResponse deleteTask(Long id);

    TaskResponse getTask(Long id);

    TaskListResponse getTaskList();

    TaskResponse updateTask(Long id, CreateTaskRequest request);

}
