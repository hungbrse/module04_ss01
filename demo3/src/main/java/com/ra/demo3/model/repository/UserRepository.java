package com.ra.demo3.model.repository;

import com.ra.demo3.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
