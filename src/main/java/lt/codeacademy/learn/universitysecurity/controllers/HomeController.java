package lt.codeacademy.learn.universitysecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class HomeController {
	@GetMapping("/")
	public String home() {
	return "home/index.html";
	}
	@GetMapping("/news")
	public String news() {
	return "/home/news";
	}
	@GetMapping("/about")
	public String about() {
	return "/home/about";
	}
}

