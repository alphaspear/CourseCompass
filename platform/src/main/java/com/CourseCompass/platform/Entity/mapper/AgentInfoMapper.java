package com.CourseCompass.platform.Entity.mapper;

import com.CourseCompass.platform.Entity.AgentInfo;
import com.CourseCompass.platform.Entity.dto.AgentInfoRecord;

public class AgentInfoMapper {

    public static AgentInfoRecord toDto(AgentInfo agentInfo) {
        return new AgentInfoRecord(
                agentInfo.getId(),
                agentInfo.getBaseUrl(),
                agentInfo.getAgentId(),
                agentInfo.getAgentName(),
                agentInfo.getAgentRegistrationTs()
        );
    }
}