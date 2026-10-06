package com.example.a3work.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link com.example.a3work.Model.ProjectParticipantsModel}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProjectParticipantsDto implements Serializable {
    private Long id;
    @Size(max = 150)
    @NotBlank
    private String name;
    @NotNull
    @Min(1)
    @Max(10)
    private Integer position;
}