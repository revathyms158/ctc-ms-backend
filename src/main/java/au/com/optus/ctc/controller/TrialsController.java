package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.dao.TrialsConditionRepository;
import au.com.optus.ctc.dao.TrialsSummaryRepository;
import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.GenderEnum;
import au.com.optus.ctc.model.TrialCondition;
import au.com.optus.ctc.model.TrialsSummary;
import au.com.optus.ctc.service.TrialFilterServiceIF;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.L;

/**
 * @author revathyms
 */

@RestController
@RequestMapping(value = "/api/ctc/trials")
public class TrialsController {

    private static final Logger LOG = LoggerFactory.getLogger(TrialsController.class);

    @Autowired
    ObjectMapper mapper;

    @Autowired
    TrialsSummaryRepository repository;

    @Autowired
    TrialFilterServiceIF filterService;

    @Autowired
    TrialsConditionRepository trialsConditionRepository;

    @Autowired
    AccountProfileRepository accountProfileRepository;


    @PostMapping(value = "/matchingTrials", headers = "Accept=application/json")
    public String fetchMatchingTrials(@RequestBody TrialCondition condition, Long userId) throws JsonProcessingException {
        LOG.info("inside fetchMatchingTrials():: condition ->{}", condition);
        List<TrialsSummary> result = new ArrayList<>();
        if(StringUtils.isBlank(condition.getGender())){
            condition.setGender(GenderEnum.NA.value());
        }
        if(StringUtils.isBlank(condition.getTumourSize())){
            condition.setTumourSize("Any");
        }
        if(StringUtils.isBlank(condition.getNodeNumber())){
            condition.setNodeNumber("0");
        }
        if (StringUtils.isBlank(condition.getSpreadToOtherParts()) || StringUtils.equalsIgnoreCase(condition.getSpreadToOtherParts(),"Y/N")) {
            condition.setSpreadToOtherParts("N");
            result = filterService.getMatchingTrials(condition);
        } else {
            result = filterService.getMatchingTrials(condition);
        }
        LOG.info("result :{}", result);

        //Code added to save the questions answered by user
        //We will get the value of userId from front end. currently we are hardcoding it as I have value for userId=16
         userId =16L;
        Optional<AccountProfile> account = accountProfileRepository.findById(userId);
        LOG.info("user :{}", account);


        if(account != null) {
            condition.setAccount(account.get());
            LOG.info("condition :{}", condition);
            mapper.writeValueAsString(trialsConditionRepository.save(condition));
        }
        return  mapper.writeValueAsString(result);
    }

    @GetMapping(value = "/savedTrials", headers = "Accept=application/json")
    public String fetchSavedTrials() throws JsonProcessingException {
        return mapper.writeValueAsString(trialsConditionRepository.findAll());
    }


    @GetMapping(value = "/usersSavedTrials",  headers = "Accept=application/json")
    public String getAllUsersSavedTrials() throws JsonProcessingException {
        List<TrialCondition> accounts = trialsConditionRepository.findAll();
        return mapper.writeValueAsString(accounts);
    }


    @PostMapping(value = "/removeTrials", headers = "Accept=application/json")
    public String fetchRemovedTrials(/*@RequestBody AccountProfile profile*/)  {

        return  null;
    }

}
