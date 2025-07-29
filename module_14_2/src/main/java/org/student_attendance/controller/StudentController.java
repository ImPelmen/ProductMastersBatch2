package org.student_attendance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.student_attendance.model.dto.StudentAttendanceDto;
import org.student_attendance.service.StudentService;

import java.net.Authenticator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/attendance")
    public String getStudents(Model model, Authentication authentication) {
        List<StudentAttendanceDto> students = studentService.getAll();
        model.addAttribute("students", students);
        boolean isTeacher = authentication != null && authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_TEACHER"));
        model.addAttribute("isTeacher", isTeacher);
        return "index";
    }

    @PostMapping("/attendance")
    public String addStudent(
            @RequestParam String name, @RequestParam String groupName,
            @RequestParam boolean isAttended) {
        studentService.createAttendance(name, groupName, isAttended);
        return "redirect:/attendance";
    }
}
