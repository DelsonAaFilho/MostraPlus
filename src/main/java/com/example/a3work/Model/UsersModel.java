package com.example.a3work.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "external_id", nullable = false, updatable = false)
    private UUID externalId;

    @PrePersist
    protected void assignExternalId() {
        if (externalId == null) {
            externalId = UUID.randomUUID();
        }
    }
    @Column(name = "name", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @NonNull
    @NotEmpty
    @NotBlank
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.LONGNVARCHAR)
    @NonNull
    @NotEmpty
    @NotBlank
    private String email;

    @Column(name = "password", nullable = false)
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @NonNull
    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 32)
    private String password_hash;

    @Column(name = "role", nullable = false, length = 16)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

}
