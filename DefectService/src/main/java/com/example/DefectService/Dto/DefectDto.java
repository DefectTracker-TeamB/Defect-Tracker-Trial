package com.example.DefectService.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class DefectDto {
    private int defect_id;
    private String description;
    private String severity;
    private String priority;
    private String status;
}
