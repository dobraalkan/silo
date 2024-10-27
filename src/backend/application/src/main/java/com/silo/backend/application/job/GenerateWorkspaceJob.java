package com.silo.backend.application.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.silo.backend.service.WorkspaceService;

@Component
public class GenerateWorkspaceJob {

    private final Logger log = LoggerFactory.getLogger(GenerateWorkspaceJob.class);
    private final WorkspaceService entityService;

    public GenerateWorkspaceJob (WorkspaceService entityService) {
		this.entityService = entityService;
	}

    /* Every hour, between 07:00 AM and 07:59 PM, Monday through Saturday */
    @Scheduled(cron = "0 0 7-19 * * 1-6")
    public void generate() {
        entityService.generate();
    }
}
