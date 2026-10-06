package com.example.a3work.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class CategoriesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    @NotBlank
    @NotNull
    @NotEmpty
    private String code;

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    @NotEmpty
    @NotNull
    private String name;

    @Column(name = "sort_order", nullable = false)
    private Short sort_order;


}
