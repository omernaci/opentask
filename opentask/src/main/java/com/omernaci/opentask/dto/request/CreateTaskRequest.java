package com.omernaci.opentask.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class CreateTaskRequest {

    @NotEmpty
    private String name;

    private String notes;

    private Date startDate;

    private Date dueDate;

    @Min(1)
    @Max(4)
    private int priority;

}
