package com.CourseCompass.platform.Service;

import com.CourseCompass.platform.Entity.AgentInfo;

public interface AgentInfoService {
    AgentInfo getAgentInfo(String agentId);
    AgentInfo saveAgentInfo(AgentInfo agentInfo);
}
