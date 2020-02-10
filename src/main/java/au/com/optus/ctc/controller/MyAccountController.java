package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.AccountProfileResponse;
import au.com.optus.ctc.model.TrialCondition;
import au.com.optus.ctc.service.MyAccountServiceIF;
import au.com.optus.ctc.util.UtilFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "http://172.31.5.10:4200" })
@RestController
@RequestMapping(value = "/api/ctc")
public class MyAccountController {

	private static final Logger LOG = LoggerFactory.getLogger(MyAccountController.class);

	@Autowired
	ObjectMapper mapper;

	@Autowired
	AccountProfileRepository repository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UtilFacade utilFacade;

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

		AccountProfileResponse accountProfileResponse = new AccountProfileResponse();
		if(profile != null && profile.getPassword() != null) {
			profile.setPassword(bcryptEncoder.encode(profile.getPassword()));
		}

		if(profile != null && profile.getDob() != null) {
			int age = utilFacade.calculateAge(profile.getDob());
			profile.setAge(age);
		}

    	try{
			AccountProfile user = repository.save(profile);
			mapper.writeValueAsString(user);
			LOG.info("ID generated for Profile _____________, {}", user.getId());
			accountProfileResponse.setId(user.getId());
		} catch (Exception ex) {
			if(ex.getMessage().startsWith("could not")) {
				accountProfileResponse.setErrorMessage("Duplicate entry for user");
			}
		}

		return accountProfileResponse;
	}

	@PostMapping(value = "/getAccountDetails", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE }, headers = "Accept=application/json, application/json;charset=UTF-8")
	public String getAccountProfile(@RequestBody String emailAddress)
			throws JsonProcessingException {
		LOG.info(" Get accountProfile  ____________ by  Emailaddress: , {}", emailAddress);

		AccountProfile profile = repository.findByEmailAddress(emailAddress);
		LOG.info("profile :{}", profile);
		return mapper.writeValueAsString(profile);

	}

}
