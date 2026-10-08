package com.example.a3work.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.a3work.model.ProjectSubmissionsModel}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProjectSubmissionsDto implements Serializable {
    @NotNull
    @Size(min = 1, max = 100)
    @NotEmpty
    @NotBlank
    private String title;
    @NotNull
    @Size(min = 1, max = 500)
    @NotEmpty
    @NotBlank
    private String description;
    @NotNull
    @NotEmpty
    @NotBlank
    @URL
    private String imageUrl;
    @NotNull
    @NotEmpty
    @NotBlank
    @URL(message = "Invalid URL format")
    private String url;
    @NotNull
    @Email
    @NotEmpty
    @NotBlank
    private String contactEmail;
    @Email
    private String linkedinUrl;
    @NotNull
    @NotEmpty
    @NotBlank
    @URL
    private String githubUrl;
    @NotNull
    private Integer publicationNoticeVersion;
    @NotNull
    @NotEmpty
    @NotBlank
    private String publicationNoticeText;
    @NotNull
    private Instant publicationAcknowledgedAt;
    private LocalDateTime createdAt = LocalDateTime.now();
}