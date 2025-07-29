package org.student_attendance.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.student_attendance.model.dto.StudentAttendanceDto;
import org.student_attendance.model.entity.Student;
import org.student_attendance.repository.StudentRepository;
import org.student_attendance.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ObjectMapper objectMapper;

    @Override
    public List<StudentAttendanceDto> getAll() {
        return studentRepository.findAll().stream()
                .map(student -> objectMapper.convertValue(student, StudentAttendanceDto.class)).toList();
    }

    @Override
    public void createAttendance(String name, String groupName, boolean isAttended) {
        Student student = Student.builder()
                .name(name)
                .groupName(groupName)
                .isAttended(isAttended)
                .build();

        studentRepository.save(student);
    }
}
