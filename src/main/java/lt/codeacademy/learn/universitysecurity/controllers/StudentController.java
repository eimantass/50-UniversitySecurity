package lt.codeacademy.learn.universitysecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class StudentController {
	@GetMapping("/student/home")
	public String studentHome() {
	return "/student/studenthome";
	}
	@GetMapping("/student/tasks")
	public String studentTasks() {
	return "/student/studenttasks";
	}
	@GetMapping("/student/courses")
	public String studentCourses() {
	return "/student/courses";
	}
}
