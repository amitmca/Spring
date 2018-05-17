package org.krams.tutorial.controller;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.krams.tutorial.domain.User;
import org.krams.tutorial.json.CustomGenericResponse;
import org.krams.tutorial.json.CustomUserResponse;
import org.krams.tutorial.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/crud")
public class UserController {

	protected static Logger logger = Logger.getLogger("controller");

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getUsersPage() {
		logger.debug("Received request to show users page");
		return "users";
	}

	/**
	 * The default method when a request to /users is made. This essentially
	 * retrieves all users, which are wrapped inside a CustomUserResponse
	 * object. The object is automatically converted to JSON when returning back
	 * the response. The @ResponseBody is responsible for this behavior.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	CustomUserResponse getAll() {
		logger.debug("Received request to get all users");

		List<User> users = userService.getAll();
		CustomUserResponse response = new CustomUserResponse();
		response.setRows(users);
		response.setRecords(String.valueOf(users.size()));
		// Since our service is just a simple service for teaching purposes
		// We didn't really do any paging. But normally your DAOs or your
		// persistence layer should support this
		// Assign a dummy page
		response.setPage("1");
		// Same. Assign a dummy total pages
		response.setTotal("10");
		// Return the response
		// Spring will automatically convert our CustomUserResponse as JSON
		// object.
		// This is triggered by the @ResponseBody annotation.
		// It knows this because the JqGrid has set the headers to accept JSON
		// format when it made a request
		// Spring by default uses Jackson to convert the object to JSON
		return response;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody
	CustomGenericResponse edit(@RequestParam("id") int id,
			@RequestParam("username") String username,
			@RequestParam("address") String address,
			@RequestParam("email") String email) {
		logger.debug("Received request to edit user");
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setAddress(address);
		user.setEmail(email);
		userService.edit(user);
		int id1 = user.getId();
		// Check if successful
		if (id1 > 0) {
			// Success. Return a custom response
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(true);
			response.setMessage("Action successful!");
			return response;

		} else {
			// A failure. Return a custom response as well
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(false);
			response.setMessage("Action failure!");
			return response;
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	CustomGenericResponse add(@RequestParam("username") String username,
			@RequestParam("address") String address,
			@RequestParam("email") String email) {
		logger.debug("Received request to add a new user");
		User user = new User();
		user.setUsername(username);
		user.setAddress(address);
		user.setEmail(email);
		userService.add(user);
		int id1 = user.getId();
		// Check if successful
		if (id1 > 0) {
			// Success. Return a custom response
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(true);
			response.setMessage("Action successful!");
			return response;

		} else {
			// A failure. Return a custom response as well
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(false);
			response.setMessage("Action failure!");
			return response;
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	CustomGenericResponse delete(@RequestParam("id") int id) {
		logger.debug("Received request to delete an existing user");
		userService.delete(id);
		// Check if successful
		if (id > 0) {
			// Success. Return a custom response
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(true);
			response.setMessage("Action successful!");
			return response;

		} else {
			// A failure. Return a custom response as well
			CustomGenericResponse response = new CustomGenericResponse();
			response.setSuccess(false);
			response.setMessage("Action failure!");
			return response;
		}
	}
}