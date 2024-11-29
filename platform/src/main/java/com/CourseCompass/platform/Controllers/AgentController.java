package com.CourseCompass.platform.Controllers;

import com.CourseCompass.platform.Entity.dto.AgentInfoRecord;
import com.CourseCompass.platform.Service.AgentInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/agent")
public record AgentController(AgentInfoService agentInfoService) {


}
