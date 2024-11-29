package com.CourseCompass.platform.Repository;

import com.CourseCompass.platform.Entity.AgentInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AgentInfoRepo extends CrudRepository<AgentInfo, Integer> {
    Optional<AgentInfo> findByAgentId(UUID agentId);
}
