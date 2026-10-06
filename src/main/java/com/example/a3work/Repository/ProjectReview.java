package com.example.a3work.Repository;

import com.example.a3work.Model.ProjectReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectReview extends JpaRepository<ProjectReviewModel, Long> {
}
