package com.fg.workflow.model.po;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignHistory {
    private String id;

    private String workFlowId;

    private String workItemId;

    private Short seq;

    private String action;

    private SignDetail detail;

    private String creater;

    private LocalDateTime createTime;
    
}