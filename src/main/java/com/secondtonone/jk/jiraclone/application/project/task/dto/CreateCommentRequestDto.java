package com.secondtonone.jk.jiraclone.application.project.task.dto;

import java.util.UUID;

public class CreateCommentRequestDto {
    private String content;
    private UUID creatorId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(UUID creatorId) {
        this.creatorId = creatorId;
    }
}
