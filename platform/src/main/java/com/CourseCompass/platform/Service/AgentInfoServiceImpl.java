package com.CourseCompass.platform.Service;

import com.CourseCompass.platform.Entity.AgentInfo;
import com.CourseCompass.platform.Entity.dto.AgentInfoRecord;
import com.CourseCompass.platform.Repository.AgentInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AgentInfoServiceImpl implements AgentInfoService{

    private final AgentInfoRepo agentInfoRepo;
    @Autowired
    public AgentInfoServiceImpl(AgentInfoRepo agentInfoRepo) {
        this.agentInfoRepo = agentInfoRepo;
    }
    @Override
    public AgentInfo getAgentInfo(String agentId) {
        Optional<AgentInfo> optionalAgentInfo = agentInfoRepo.findByAgentId(UUID.fromString(agentId));
        return optionalAgentInfo.orElse(null);
    }

    @Override
    public AgentInfo saveAgentInfo(AgentInfo agentInfo) {
        Optional<AgentInfo> optionalAgentInfo = agentInfoRepo.findByAgentId(agentInfo.getAgentId());
        if (optionalAgentInfo.isPresent()) {
            System.out.println("Agent is already registered "+agentInfo.getAgentId());
            return null;
        }
        agentInfoRepo.save(agentInfo);
        return agentInfo;
    }
}
