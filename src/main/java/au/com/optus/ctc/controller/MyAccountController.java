package au.com.optus.ctc.controller;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

@CrossOrigin(origins = { "http://172.31.5.10:4200" })
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

	/*@PostMapping(value = "/myaccount/createAccountProfile", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE }, headers = "Accept=application/json, application/json;charset=UTF-8")
	public AccountProfileResponse createAccountProfile(@RequestBody AccountProfile profile)
			throws JsonProcessingException {
		LOG.info("accountProfile ___________________________________________, {}", profile.toString());
		*//*
		 * if (profile != null) { LOG.info("accountProfile, {}",
		 * profile.toString()); if
		 * (filterService.findEmail(profile.getEmailAddress()) == 0) {
		 * profile.setId(UUID.randomUUID().toString());
		 * mapper.writeValueAsString(repository.save(profile)); }
		 * 
		 * }
		 *//*
		profile.setId(UUID.randomUUID().toString());
		mapper.writeValueAsString(repository.save(profile));
		LOG.info("ID generated for Profile _____________, {}", profile.getId());
		AccountProfileResponse accountProfileResponse = new AccountProfileResponse();
		accountProfileResponse.setId(profile.getId());
		return accountProfileResponse;
	}*/


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
    	AccountProfile user = repository.save(profile);
		mapper.writeValueAsString(user);
		LOG.info("ID generated for Profile _____________, {}", user.getId());
		AccountProfileResponse accountProfileResponse = new AccountProfileResponse();
		accountProfileResponse.setId(user.getId());
		return accountProfileResponse;
	}

	@RequestMapping(value = "/myaccount/getAccountProfile/{userId}", method = RequestMethod.GET)
	public Optional<AccountProfile> getAccountProfile(@PathVariable final Long userId)
			throws JsonProcessingException {
		LOG.info(" Get accountProfile  ____________ for  ID: , {}", userId);
		return repository.findById(userId);

	}

}
