package com.omernaci.opentask.dto.response;

import com.omernaci.opentask.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskListResponse extends BaseApiResponse {

    private List<TaskDto> tasks;

    {
        tasks = new ArrayList<>();
    }

}
