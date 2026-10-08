package com.example.a3work.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.example.a3work.model.UsersModel}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UsersDto implements Serializable {
    private Long id;
    private UUID externalId;
    @NotEmpty
    @NotBlank
    private String name;
    @Email
    @NotEmpty
    @NotBlank
    private String email;
    @Size(min = 8, max = 32)
    @NotEmpty
    @NotBlank
    private String password_hash;
    private String role;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}