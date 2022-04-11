package com.vifrin.notification.messaging;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class CommentEventPayload {
    private Long targetId;
    private Long commentId;
    private Instant createdAt;
    private Instant updatedAt;
    private Long userId;
    private int star;
    private CommentEventType eventType;

}
