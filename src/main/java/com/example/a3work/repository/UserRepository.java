package com.example.a3work.repository;

import com.example.a3work.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersModel, Long> {
}
