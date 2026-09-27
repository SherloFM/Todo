package com.ga.Todo.repository;

import com.ga.Todo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsbyEmailAddress(String emailAddress);
    User findbyEmailAddress(String emailAddress);
}
