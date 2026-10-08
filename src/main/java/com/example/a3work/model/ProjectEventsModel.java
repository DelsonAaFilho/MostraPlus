package com.example.a3work.model;

import com.example.a3work.enums.ProjectEventType;
import com.example.a3work.enums.ProjectStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.Instant;

@Entity
@Table(
        name = "project_events",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_events_type",
                columnNames = {
                        "project_id",
                        "submission_no",
                        "event_type"
                }
        )
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectEventsModel {
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
                    name = "fk_events_submission",
                    foreignKeyDefinition = "FOREIGN KEY (project_id, submission_no) REFERENCES project_submissions (project_id, submission_no) ON DELETE RESTRICT ON UPDATE RESTRICT"
            )
    )
    private ProjectSubmissionsModel submission;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "actor_id",
            referencedColumnName = "id",
            nullable = false,
            updatable = false,
            foreignKey = @ForeignKey(
                    name = "fk_events_actor_user",
                    foreignKeyDefinition = "FOREIGN KEY (actor_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE RESTRICT"
            )
    )
    private UsersModel actor;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(
            name = "event_type",
            nullable = false,
            length = 32,
            updatable = false
    )
    private ProjectEventType eventType;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status", length = 16, updatable = false)
    private ProjectStatus fromStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(
            name = "to_status",
            nullable = false,
            length = 16,
            updatable = false
    )
    private ProjectStatus toStatus;

    @CreationTimestamp(source = SourceType.DB)
    @Column(
            name = "occurred_at",
            nullable = false,
            updatable = false
    )
    private Instant occurredAt;
}
