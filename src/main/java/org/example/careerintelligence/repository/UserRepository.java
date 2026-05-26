package org.example.careerintelligence.repository;

import org.example.careerintelligence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}