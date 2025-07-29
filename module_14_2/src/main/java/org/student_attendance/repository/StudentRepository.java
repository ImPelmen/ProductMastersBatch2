package org.student_attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.student_attendance.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
