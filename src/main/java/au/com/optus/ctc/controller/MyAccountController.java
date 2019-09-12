package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.MyAccountRepository;
import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.GenderEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping(value = "/api/ctc")
public class MyAccountController {

    private static final Logger LOG = LoggerFactory.getLogger(MyAccountController.class);

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MyAccountRepository repository;

    @GetMapping(value = "/myaccount/accountProfile", headers = "Accept=application/json")
    public String createAccountProfile(/*@RequestBody AccountProfile profile*/) throws JsonProcessingException {

       /* if (profile != null){
            LOG.info("accountProfile, {}",profile);
            //myAccountService.validateProfile(profile);
            //todo init
        }*/
        AccountProfile accountProfile = new AccountProfile("firstName4","lastName", 45, GenderEnum.F, "user",new Date("12/12/1984"), "0456678980", "email4@mail.com", "2113");
        //repository.save(profile);

        return mapper.writeValueAsString(accountProfile);
    }

}
