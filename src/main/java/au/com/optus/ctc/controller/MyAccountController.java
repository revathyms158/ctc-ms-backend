package au.com.optus.ctc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.optus.ctc.dao.MyAccountFilterSpecification;
import au.com.optus.ctc.dao.MyAccountRepository;
import au.com.optus.ctc.model.AccountProfile;

/**
 * @author revathyms
 */
@RestController
@RequestMapping(value = "/api/ctc")
public class MyAccountController {

	private static final Logger LOG = LoggerFactory.getLogger(MyAccountController.class);

	@Autowired
	ObjectMapper mapper;

	@Autowired
	MyAccountRepository repository;

	@Autowired
	MyAccountFilterSpecification filterService;

	@PostMapping(value = "/myaccount/createAccountProfile", headers = "Accept=application/json")
	public String createAccountProfile(@RequestBody AccountProfile profile) throws JsonProcessingException {

		if (profile != null) {
			LOG.info("accountProfile, {}", profile.toString());
			// myAccountService.validateProfile(profile);
			// todo init
		}
		// AccountProfile accountProfile = new
		// AccountProfile("firstName4","lastName", 45, GenderEnum.F, "user",new
		// Date("12/12/1984"), "0456678980", "email4@mail.com", "2113");
		// repository.save(profile);

		mapper.writeValueAsString(repository.save(profile));
		return "Success";
	}

	@GetMapping(value = "/myaccount/getAccountProfile/{userId}", headers = "Accept=application/json")
	public String getAccountProfile(@PathParam(value = "userId") String userId) throws JsonProcessingException {
		List<AccountProfile> result = new ArrayList<>();
		if (!StringUtils.isBlank(userId)) {
			System.out.println("User Id : " + userId);
			LOG.info("accountProfile for UserId: {}", userId);
			result = (List<AccountProfile>) filterService.accWithUserId(userId);
		}
		LOG.info("result :{}", result);
		return mapper.writeValueAsString(result);

	}

}
