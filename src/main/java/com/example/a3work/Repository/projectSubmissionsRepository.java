package com.example.a3work.Repository;

import com.example.a3work.Model.ProjectSubmissionsModel;
import com.example.a3work.Model.id.ProjectSubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projectSubmissionsRepository extends JpaRepository<ProjectSubmissionsModel, ProjectSubmissionId> {
}
