package com.example.a3work.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "project_participants",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_participants_position",
                columnNames = {"project_id", "submission_no", "position"}
        )
)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(
                    name = "project_id",
                    referencedColumnName = "project_id",
                    nullable = false
            ),
            @JoinColumn(
                    name = "submission_no",
                    referencedColumnName = "submission_no",
                    nullable = false
            )
    })
    private ProjectSubmissionsModel submission;

    @NotBlank
    @Size(max = 150)
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotNull
    @Min(1)
    @Max(10)
    @Column(name = "position", nullable = false)
    private Integer position;
}

