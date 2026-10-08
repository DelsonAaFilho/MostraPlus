package com.example.a3work.repository;

import com.example.a3work.model.ProjectSubmissionsModel;
import com.example.a3work.model.id.ProjectSubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projectSubmissionsRepository extends JpaRepository<ProjectSubmissionsModel, ProjectSubmissionId> {
}
