package com.vifrin.common.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author: tranmanhhung
 * @since: Sun, 12/12/2021
 **/

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SecondaryTable(name = "activities", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "star")
    private int star;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at")
    @LastModifiedBy
    private Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Embedded
    private Activity activity;

    public Comment(String content, User user, Post post) {
        this.content = content;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.user = user;
        this.post = post;
        this.activity = new Activity();
    }

    public Comment(String content, User user, Destination destination) {
        this.content = content;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.user = user;
        this.destination = destination;
        this.activity = new Activity();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", star=" + star +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", post=" + post +
                ", user=" + user +
                ", destination=" + destination +
                ", hotel=" + hotel +
                ", activity=" + activity +
                '}';
    }
}
