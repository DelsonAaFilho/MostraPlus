package com.example.a3work.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project_submissions")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class projectSubmissionsModel {

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectsModel project;

    @OneToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UsersModel author;

    @OneToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private UsersModel professor;

    



}
