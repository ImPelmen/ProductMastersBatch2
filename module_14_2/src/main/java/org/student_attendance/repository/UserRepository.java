package org.student_attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.student_attendance.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
