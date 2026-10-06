package com.example.a3work.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProjectsModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "external_id", nullable = false, updatable = false)
    private UUID externalId;

    @PrePersist
    protected void assignExternalId() {
        if (externalId == null) {
            externalId = UUID.randomUUID();
        }
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="author_id", nullable = false)
    private UsersModel author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="professor_id", nullable = false)
    private UsersModel professor;

    @Column(name="current_submission_no", nullable = false)
    private Integer currentSubmissionNo = 1;

    @Column(name="status", nullable = false)
    @NotBlank
    @NotEmpty
    @NotNull
    private String status = "PENDING";

    @CreationTimestamp
    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @CreationTimestamp
    @Column(name="withdrawn_at", updatable = false)
    private LocalDateTime withdrawnAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "version")
    @NotBlank
    @NotNull

    @PositiveOrZero
    private int version = 0;
}
