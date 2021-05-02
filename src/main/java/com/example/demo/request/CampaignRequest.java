package com.example.demo.request;

import com.example.demo.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class CampaignRequest extends BaseDTO {
    private String name;
    private String state;
    private Timestamp startDate;
    private Timestamp endDate;
    private String description;
    private Integer version;
    private Integer published;
    private Integer priority;
    private Integer repeatable;
    private String upName;
    private String upDescription;
    private String image;
    private String rules;
    private String type;
    private UUID customerSegment;
    private UUID tenantId;
    private UUID orgId;
    private UUID cycleId;
}
