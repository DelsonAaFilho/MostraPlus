package com.example.a3work.DTO;

import com.example.a3work.enums.ProjectEventType;
import com.example.a3work.enums.ProjectStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.example.a3work.Model.ProjectEventsModel}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProjectEventsDto implements Serializable {
    private Long id;
    @NotNull
    private ProjectEventType eventType;
    private ProjectStatus fromStatus;
    @NotNull
    private ProjectStatus toStatus;
    private Instant occurredAt;
}