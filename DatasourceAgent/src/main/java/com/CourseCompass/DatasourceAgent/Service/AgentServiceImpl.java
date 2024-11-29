package com.CourseCompass.DatasourceAgent.Service;


import com.CourseCompass.DatasourceAgent.Entity.AgentInfo;
import com.CourseCompass.DatasourceAgent.Repository.AgentInfoRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AgentServiceImpl implements AgentService {
    private final AgentInfoRepo agentInfoRepo;

    @Autowired
    public AgentServiceImpl(AgentInfoRepo agentInfoRepo) {
        this.agentInfoRepo = agentInfoRepo;
    }

    @Override
    public AgentInfo initializeAgent() {
        if (!agentInfoRepo.findAll().iterator().hasNext()) {
            UUID agentUniqueId = UUID.randomUUID();
            AgentInfo newAgent = new AgentInfo(agentUniqueId);
            newAgent.setAgentCreateTs(LocalDateTime.now());
            agentInfoRepo.save(newAgent);
            registerAgentWithPlatform(agentUniqueId);

            return newAgent;
        } else {
            throw new IllegalStateException("Agent is already initialized");
        }
    }


    private void registerAgentWithPlatform(UUID agentUniqueId) {
        System.out.println("Registering agent with UUID: " + agentUniqueId);
    }

}
