package com.springsecurity.ProductManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
	@Autowired
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping
	public List<User> getStudents(){


		return userService.getUsers();
	}
	@PostMapping
	public void registerNewUser(@RequestBody User user){
		userService.addNewUser(user);
	}

	@DeleteMapping(path = "{userId}")
	public void deleteUser(@PathVariable("userId") Long userId){
		userService.deleteUser(userId);
	}

	@PutMapping(path = "{userId}")
	public void updateStudent(
			@PathVariable("userId") Long userId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email)
	{
		userService.updateStudent(userId,name);
	}
}*/
@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/newUser")
	public String showNewUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		service.save(user);

		return "redirect:/";
	}

}