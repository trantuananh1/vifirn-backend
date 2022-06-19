package com.vifrin.common.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author: tranmanhhung
 * @since: Tue, 21/12/2021
 **/

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "notification_changes")
public class NotificationChange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actor_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "notification_object_id", nullable = false)
    private NotificationObject notificationObject;

    public NotificationChange(User user, NotificationObject notificationObject){
        this.user = user;
        this.notificationObject = notificationObject;
    }
}
