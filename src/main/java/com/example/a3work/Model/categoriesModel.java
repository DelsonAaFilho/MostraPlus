package com.example.a3work.Model;
import com.example.a3work.enums.categoriesEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class categoriesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable=false, updatable=false)
    private Integer id ;

    @Column(name="code", nullable=false, unique=true)
    @NotBlank
    @NotNull
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private categoriesEnum code;

    @Column(name="name", nullable=false, unique=true)
    @NotBlank
    @NotEmpty
    @NotNull
    private String name;

    @Column(name="sort_order", nullable=false)
    private Integer sort_order;



}
