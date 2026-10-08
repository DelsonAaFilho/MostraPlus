package com.example.a3work.repository;

import com.example.a3work.model.ProjectReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectReview extends JpaRepository<ProjectReviewModel, Long> {
}
