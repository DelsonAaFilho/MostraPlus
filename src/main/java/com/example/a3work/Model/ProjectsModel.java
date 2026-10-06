package com.example.a3work.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name="author_id", nullable = false)
    @NotBlank
    @NotEmpty
    @NotNull
    private String authorId;

    @Column(name="professor_id", nullable = false)
    @NotBlank
    @NotEmpty
    @NotNull
    private String professorId;

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
    @NotEmpty
    private int version = 0;
}
