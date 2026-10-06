package com.example.a3work.Model;


import com.example.a3work.Model.id.ProjectSubmissionId;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.URL;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "project_submissions")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProjectSubmissionsModel {

    @EmbeddedId
    private ProjectSubmissionId id;

    @MapsId("projectId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "project_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_submissions_project",
                    foreignKeyDefinition = "FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE RESTRICT ON UPDATE RESTRICT"
            )
    )
    private ProjectsModel project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "category_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_submissions_category",
                    foreignKeyDefinition = "FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE RESTRICT ON UPDATE RESTRICT"
            )
    )
    private CategoriesModel category;

    @Column(name = "title", nullable = false)
    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 100)
    private String title;

    @Column(name = "description", nullable = false)
    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 500)
    private String description;

    @Column(name = "image_url", nullable = false)
    @NotBlank
    @NotNull
    @NotEmpty
    @URL
    private String imageUrl;

    @Column(name = "web_url", nullable = false)
    @NotBlank
    @NotNull
    @NotEmpty
    @URL(message = "Invalid URL format")
    private String url;

    @Column(name= "contact_email", nullable = false)
    @Email
    @NotBlank
    @NotNull
    @NotEmpty
    private String contactEmail;

    @Column(name = "linkedin_url")
    @Email
    private String linkedinUrl;

    @Column(name = "github_url")
    @URL
    @NotBlank
    @NotNull
    @NotEmpty
    private String githubUrl;

    @Column(name = "publication_notice_version", nullable = false)
    @Size(min = 1, max = 32)
    @NotNull
    @NotEmpty
    @NotEmpty
    private Integer publicationNoticeVersion;

    @Column(name = "publication_notice_text", nullable = false)
    @NotEmpty
    @NotBlank
    @NotNull
    private String publicationNoticeText;


    @NotNull
    @Column(name = "publication_acknowledged_at", nullable = false)
    private Instant publicationAcknowledgedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();
}
