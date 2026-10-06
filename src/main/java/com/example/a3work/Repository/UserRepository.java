package com.example.a3work.Repository;

import com.example.a3work.Model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UsersModel, Long> {
}
