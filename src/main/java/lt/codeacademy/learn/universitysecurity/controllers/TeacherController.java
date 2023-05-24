package lt.codeacademy.learn.universitysecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {
	@GetMapping("/teacher/home")
	public String teacherHome() {
	return "/teacher/teacherhome";
	}
	@GetMapping("/teacher/timetable")
	public String teacherTimeTable() {
	return "/teacher/teacherTimeTable";
	}
	@GetMapping("/teacher/resources")
	public String teacherResources() {
	return "/teacher/teacherresources";
	}
}
