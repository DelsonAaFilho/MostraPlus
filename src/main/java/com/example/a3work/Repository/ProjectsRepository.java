package com.example.a3work.Repository;

import com.example.a3work.Model.ProjectsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectsRepository extends JpaRepository<ProjectsModel, Long> {
}
