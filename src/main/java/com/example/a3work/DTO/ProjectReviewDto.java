package com.example.a3work.DTO;

import com.example.a3work.enums.ReviewDecision;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.example.a3work.Model.ProjectReviewModel}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProjectReviewDto implements Serializable {
    private Long id;
    @NotNull
    private ReviewDecision decision;
    private String comment;
    private Instant reviewedAt;
}