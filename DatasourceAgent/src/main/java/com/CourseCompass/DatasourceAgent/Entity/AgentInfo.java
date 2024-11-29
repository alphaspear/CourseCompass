package com.CourseCompass.DatasourceAgent.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "agent_info")
public class AgentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agent-unique-id")
    private UUID agentUniqueId;

    @Column(name = "agent-create-ts")
    private LocalDateTime agentCreateTs;

    public AgentInfo() {

    }

    public AgentInfo(UUID agentUniqueId) {
        this.agentUniqueId = agentUniqueId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getAgentUniqueId() {
        return agentUniqueId;
    }

    public void setAgentUniqueId(UUID agentUniqueId) {
        this.agentUniqueId = agentUniqueId;
    }

    public LocalDateTime getAgentCreateTs() {
        return agentCreateTs;
    }

    public void setAgentCreateTs(LocalDateTime agentCreateTs) {
        this.agentCreateTs = agentCreateTs;
    }
}
