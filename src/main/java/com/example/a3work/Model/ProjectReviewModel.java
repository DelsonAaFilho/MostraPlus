package com.example.a3work.Model;

import com.example.a3work.enums.ReviewDecision;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        name = "project_reviews",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_reviews_submission",
                columnNames = {"project_id", "submission_no"}
        )
)

public class ProjectReviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns(
            value = {
                    @JoinColumn(
                            name = "project_id",
                            referencedColumnName = "project_id",
                            nullable = false,
                            updatable = false
                    ),
                    @JoinColumn(
                            name = "submission_no",
                            referencedColumnName = "submission_no",
                            nullable = false,
                            updatable = false
                    )
            },
            foreignKey = @ForeignKey(
                    name = "fk_reviews_submission",
                    foreignKeyDefinition = "FOREIGN KEY (project_id, submission_no) REFERENCES project_submissions (project_id, submission_no) ON DELETE RESTRICT ON UPDATE RESTRICT"
            )
    )
    private ProjectSubmissionsModel submission;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "professor_id",
            nullable = false,
            updatable = false,
            foreignKey = @ForeignKey(
                    name = "fk_reviews_professor_user",
                    foreignKeyDefinition = "FOREIGN KEY (professor_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE RESTRICT"
            )
    )
    private UsersModel professor;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(
            name = "decision",
            nullable = false,
            length = 16,
            updatable = false
    )
    private ReviewDecision decision;

    @Column(name = "comment", columnDefinition = "text", updatable = false)
    private String comment;

    @CreationTimestamp
    @Column(name = "reviewed_at", nullable = false, updatable = false)
    private Instant reviewedAt;

}
