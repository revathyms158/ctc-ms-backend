package au.com.optus.ctc.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.MediaType;
import au.com.optus.ctc.model.TrialCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.AccountProfileResponse;
import au.com.optus.ctc.service.MyAccountServiceIF;


import java.util.List;
import java.util.Optional;

/**
 * @author revathyms
 */
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping(value = "/api/ctc")
public class MyAccountController {

	private static final Logger LOG = LoggerFactory.getLogger(MyAccountController.class);

	@Autowired
	ObjectMapper mapper;

	@Autowired
	AccountProfileRepository repository;

	@Autowired(required = false)
	MyAccountServiceIF filterService;

	@PostMapping(value = "/myaccount/createAccountProfile", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE }, headers = "Accept=application/json, application/json;charset=UTF-8")
	public AccountProfileResponse createAccountProfile(@RequestBody AccountProfile profile)
			throws JsonProcessingException {
		LOG.info("accountProfile ___________________________________________, {}", profile.toString());
		/*
		 * if (profile != null) { LOG.info("accountProfile, {}",
		 * profile.toString()); if
		 * (filterService.findEmail(profile.getEmailAddress()) == 0) {
		 * profile.setId(UUID.randomUUID().toString());
		 * mapper.writeValueAsString(repository.save(profile)); }
		 * 
		 * }
		 */
		profile.setId(UUID.randomUUID().toString());
		mapper.writeValueAsString(repository.save(profile));
		LOG.info("ID generated for Profile _____________, {}", profile.getId());
		AccountProfileResponse accountProfileResponse = new AccountProfileResponse();
		accountProfileResponse.setId(profile.getId());
		return accountProfileResponse;
	}

	@RequestMapping(value = "/myaccount/getAccountProfile/{userId}", method = RequestMethod.GET)
	public Optional<AccountProfile> getAccountProfile(@PathVariable final String userId)
			throws JsonProcessingException {
		LOG.info(" Get accountProfile  ____________ for  ID: , {}", userId);
		return repository.findById(userId);

	}

	@GetMapping(value = "/users",  headers = "Accept=application/json")
	public String getAllUsers() throws JsonProcessingException {
		List<AccountProfile> accounts = repository.findAll();
		return mapper.writeValueAsString(repository.findAll());
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		AccountProfile account = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		repository.delete(account);
	}

	@PutMapping("/users/{id}")
	public String createOrUpdateUser(@RequestBody AccountProfile account, @PathVariable String id)  throws JsonProcessingException
	{
		Optional<AccountProfile> user = repository.findById(id);

		if(user.isPresent())
		{
			AccountProfile newUser = user.get();
			newUser.setEmailAddress(account.getEmailAddress());
			newUser.setFirstName(account.getFirstName());
			newUser.setLastName(account.getLastName());
			newUser = repository.save(newUser);
			return mapper.writeValueAsString(newUser);
		} else {
			account = repository.save(account);
			return mapper.writeValueAsString(account);
		}
	}

}
