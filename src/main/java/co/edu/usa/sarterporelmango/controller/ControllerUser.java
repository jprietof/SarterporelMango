package co.edu.usa.sarterporelmango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import co.edu.usa.sarterporelmango.model.User;
import co.edu.usa.sarterporelmango.service.ServiceUser;

/**
 * 
 * @author jprietof
 *
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class ControllerUser {
	@Autowired
	/**
	 * call service user
	 */
	private ServiceUser userService;
	@GetMapping("/all")
	/**
	 * show all users
	 * @return
	 */
	public List<User> getAll(){
		return userService.getAll();
	}
	/**
	 * show one user
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional <User> getUser(@PathVariable("id") int id){
		return userService.getUser(id);
	}
	/**
	 * Create new user
	 * @param user
	 * @return
	 */
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	/**
	 * Update user
	 * @param user
	 * @return
	 */
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public User update(@RequestBody User user) {
		return userService.update(user);
	}
	/**
	 * Delete user
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id")int id) {
		return userService.delete(id);
	}
	/**
	 * validate user in database
	 * @param email
	 * @param password
	 * @return
	 */
	@GetMapping("/{email}/{password}")
	public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
		return userService.authenticateUser(email, password);
	}
	/**
	 * validate email
	 * @param email
	 * @return
	 */
	@GetMapping("/emailexist/{email}")
	public boolean emailExists(@PathVariable("email") String email) {
		return userService.existeEmail(email);
	}
	@GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthDayList(monthBirthtDay);
    }
	
}
