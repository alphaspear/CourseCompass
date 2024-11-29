package com.CourseCompass.DatasourceAgent.Repository;

import com.CourseCompass.DatasourceAgent.Entity.AgentInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AgentInfoRepo extends CrudRepository<AgentInfo, Long> {

    Optional<AgentInfo> findByAgentUniqueId(UUID agentUniqueId);

}
