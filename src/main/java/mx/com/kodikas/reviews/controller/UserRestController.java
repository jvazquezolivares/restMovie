package mx.com.kodikas.reviews.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.com.kodikas.reviews.entities.User;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@PostMapping("sign_up")
	public User loginUser(@RequestBody User user) {
		return null;
	}
	
	@PostMapping("sign_in")
	public User registerUser(@RequestBody User user) {
		return null;
	}
	
}
