package com.omernaci.opentask.dto.response;

import com.omernaci.opentask.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse extends BaseApiResponse {

    private TaskDto task;

}
