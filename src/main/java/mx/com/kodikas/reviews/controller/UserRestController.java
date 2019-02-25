package mx.com.kodikas.reviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import mx.com.kodikas.reviews.entities.User;
import mx.com.kodikas.reviews.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	/*@PostMapping("/sign_in")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> loginUser(@RequestBody User user) {
		return null;
	}*/
	
	@PostMapping("/sign_up")
	public ResponseEntity<Void> registerUser(@RequestBody User user) {
		if(userService.findUser(user) == null ) {
			userService.createUser(user);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
}
