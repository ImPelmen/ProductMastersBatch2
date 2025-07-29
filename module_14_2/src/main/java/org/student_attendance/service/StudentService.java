package org.student_attendance.service;

import org.student_attendance.model.dto.StudentAttendanceDto;

import java.util.List;

public interface StudentService {

    List<StudentAttendanceDto> getAll();

    void createAttendance(String name, String groupName, boolean isAttended);
}
