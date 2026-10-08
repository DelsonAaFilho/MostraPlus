package com.example.a3work.repository;

import com.example.a3work.model.ProjectsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<ProjectsModel, Long> {
}
