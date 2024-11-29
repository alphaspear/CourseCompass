package com.CourseCompass.platform.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "agent_info", schema = "public")
public class AgentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated, auto-incrementing primary key

    @Column(name = "base_url", nullable = false)
    private String baseUrl; // Base URL of the agent

    @Column(name = "agent_id", nullable = false, unique = true)
    private UUID agentId; // Unique identifier for the agent

    @Column(name = "agent_name", nullable = false)
    private String agentName; // Name of the agent

    @Column(name = "agent_registration_ts", nullable = false, updatable = false)
    private LocalDateTime agentRegistrationTs; // Registration timestamp


    public AgentInfo() {}


    public AgentInfo(String baseUrl, UUID agentId, String agentName) {
        this.baseUrl = baseUrl;
        this.agentId = agentId;
        this.agentName = agentName;
        this.agentRegistrationTs = LocalDateTime.now(); // Set to current time by default
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public UUID getAgentId() {
        return agentId;
    }

    public void setAgentId(UUID agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public LocalDateTime getAgentRegistrationTs() {
        return agentRegistrationTs;
    }

    public void setAgentRegistrationTs(LocalDateTime agentRegistrationTs) {
        this.agentRegistrationTs = agentRegistrationTs;
    }
}
