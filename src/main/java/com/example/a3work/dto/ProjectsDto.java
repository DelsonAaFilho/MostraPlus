package com.example.a3work.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.example.a3work.model.ProjectsModel}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProjectsDto implements Serializable {
    private Long id;
    private UUID externalId;
    private Integer currentSubmissionNo = 1;
    @NotNull
    @NotEmpty
    @NotBlank
    private String status = "PENDING";
    private LocalDateTime publishedAt;
    private LocalDateTime withdrawnAt;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    @PositiveOrZero
    private int version = 0;
}