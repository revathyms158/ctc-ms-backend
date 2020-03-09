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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author revathyms
 */

@CrossOrigin(origins = { "http://172.31.5.10:4200" })
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

    @Autowired
    TrialsSummaryRepository trialsSummaryRepository;


    /*@PostMapping(value = "/matchingTrials", headers = "Accept=application/json")
    public String fetchMatchingTrials(@RequestBody TrialCondition condition) throws JsonProcessingException {
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

        if(condition !=null && condition.getAccountUserId()!= null){
            Long id = condition.getAccountUserId();
            Optional<AccountProfile> account = accountProfileRepository.findById(id);
            LOG.info("Trial account details :{}", account);
            System.out.println(account);
            if(account != null) {
                condition.setAccount(account.get());
            }
        }

        TrialCondition trials = trialsConditionRepository.save(condition);
        LOG.info("trial conditions :{}", trials);

        if(result !=null && !result.isEmpty()) {
          List<TrialsSummary> trialsSummaries = trialsSummaryRepository.saveAll(result);
        }
        return  mapper.writeValueAsString(result);
    }*/




    @PostMapping(value = "/matchingTrials", headers = "Accept=application/json")
    public String fetchMatchingTrials(@RequestBody TrialCondition condition) throws JsonProcessingException {
        LOG.info("inside fetchMatchingTrials():: condition ->{}", condition);
        List<TrialsSummary> result = new ArrayList<>();
        if(StringUtils.isBlank(condition.getSex())){
            condition.setSex(GenderEnum.NA.value());
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
        TrialCondition trials = null;
        if(condition.getQuesId() != null) {
            trials = trialsConditionRepository.findById(condition.getQuesId()).get();
            trialsConditionRepository.save(condition);
            LOG.info("Entering If block for second time user modifies questions :{}", trials);
        } else{
            trials = trialsConditionRepository.save(condition);
            LOG.info("Entering else block for first time user answers questions :{}", trials);
        }

        LOG.info("trial conditions :{}", trials);

       /* List<TrialsSummary> trialsSummaries = null;
        if(result !=null && !result.isEmpty()) {
            trialsSummaries  = trialsSummaryRepository.saveAll(result);
        }*/


        LOG.info("Entering Account Details....");
        AccountProfile account = null;
        if(condition !=null && condition.getAccountUserId()!= null){
            Long id = condition.getAccountUserId();
            account = accountProfileRepository.findById(id).get();
            LOG.info("Account Details without trials :{}", account);
            if(account != null) {
                account.setCondition(trials);
                account.setSummaries(result);
                account = accountProfileRepository.save(account);
                LOG.info("account with trial details :{}", account);
                LOG.info("account with trial details :{}", account.getSummaries());
            }
        }

        return  mapper.writeValueAsString(result);
    }


    @GetMapping(value = "/userList",  headers = "Accept=application/json")
    public String getAllUsersSavedTrials() throws JsonProcessingException {
        List<AccountProfile> accounts = accountProfileRepository.findAll();
        LOG.info("Account with conditions :{}", accounts);
        return mapper.writeValueAsString(accounts);
    }

    @PostMapping(value = "/userSpecificTrials/{userID}", headers = "Accept=application/json")
    public String fetchUserSpecificTrialConditions(@PathVariable final Long userID)  throws JsonProcessingException {
        AccountProfile account = accountProfileRepository.findById(userID).get();
        return mapper.writeValueAsString(account);
    }


    /*@PostMapping(value = "/userSpecificTrialSummary/{userID}", headers = "Accept=application/json")
    public String fetchUserSpecificTrialSummary(@PathVariable final Long userID)  throws JsonProcessingException {
        AccountProfile account = accountProfileRepository.findById(userID).get();
        return mapper.writeValueAsString(account);
    }

*/
    @PostMapping(value = "/removeUser/{userID}", headers = "Accept=application/json")
    public String fetchRemovedTrials(@PathVariable final Long userID)  {
        AccountProfile account = accountProfileRepository.findById(userID).get();
        if(account != null && account.getCondition().getQuesId()!= null) {
            LOG.info("Insert into if condition for delete");
            Long id = account.getCondition().getQuesId();
            accountProfileRepository.deleteById(userID);
            trialsConditionRepository.deleteById(id);
        } else{
            LOG.info("Insert into else condition for delete");
            accountProfileRepository.deleteById(userID);
        }
        return "Trial is deleted";
    }

    @GetMapping(value = "/trialsSummary",  headers = "Accept=application/json")
    public String getAllUsersSavedTrialSummary() throws JsonProcessingException {
        List<TrialsSummary> summaries = trialsSummaryRepository.findAll();
        LOG.info("trial summary :{}", summaries);
        return mapper.writeValueAsString(summaries);
    }

}
