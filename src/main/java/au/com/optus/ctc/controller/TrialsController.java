package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.dao.TrialsConditionRepository;
import au.com.optus.ctc.dao.TrialsSummaryRepository;
import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.GenderEnum;
import au.com.optus.ctc.model.TrialCondition;
import au.com.optus.ctc.model.TrialsSpecificParams;
import au.com.optus.ctc.model.TrialsSummary;
import au.com.optus.ctc.service.TrialFilterServiceIF;
import au.com.optus.ctc.util.UtilFacade;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.L;
import static org.apache.coyote.http11.Constants.a;

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

    @Autowired
    private UtilFacade utilFacade;

    @PostMapping(value = "/matchingTrials", headers = "Accept=application/json")
    public String fetchMatchingTrials(@RequestBody TrialCondition condition) throws JsonProcessingException {
        LOG.info("inside fetchMatchingTrials():: condition ->{}", condition);
        List<TrialsSummary> result = new ArrayList<>();

        if(condition != null && condition.getDob() != null) {
            int age = utilFacade.calculateAge(condition.getDob());
            condition.setAge(age);
        }

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
        AccountProfile account = null;
        if(condition !=null && condition.getAccountUserId()!= null){
            Long id = condition.getAccountUserId();
            account = accountProfileRepository.findById(id).get();
            LOG.info("Account Details without trials :{}", account);
            if(account != null) {
                account.setCondition(trials);
                //account.setSummaries(result);
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



    @PostMapping(value = "/removeUser/{userID}", headers = "Accept=application/json")
    public String fetchRemovedTrials(@PathVariable final Long userID)  throws JsonProcessingException {
        AccountProfile account = null;
        account = accountProfileRepository.findById(userID).get();
        account.setStatus("Inactive");
        account = accountProfileRepository.save(account);
        LOG.info("Account :{}", account);
        return mapper.writeValueAsString(account);
    }


    /*@GetMapping(value = "/userFavouriteTrials", headers = "Accept=application/json")
    public String userFavouriteTrials(@RequestBody TrialsSpecificParams params) throws JsonProcessingException {
        List<TrialsSummary> summaries = null;
        Long trialId = params.getTrialId();
        Long userId = params.getUserId();
        AccountProfile account = null;
        account = accountProfileRepository.findById(userId).get();
        TrialsSummary summary = trialsSummaryRepository.findById(trialId).get();
        summaries.add(summary);
        account.setSummaries(summaries);
        account = accountProfileRepository.save(account);
        LOG.info("trial summary :{}", account);
        return mapper.writeValueAsString(summaries);
    }*/


    @PostMapping(value = "/userFavouriteTrials", headers = "Accept=application/json")
    public String userFavouriteTrials(@RequestBody TrialsSpecificParams params) throws JsonProcessingException {
        List<TrialsSummary> summaries = null;
        Long trialId = params.getTrialId();
        Long userId = params.getUserId();
        AccountProfile account = null;
        account = accountProfileRepository.findById(userId).get();
        TrialsSummary summary = trialsSummaryRepository.findById(trialId).get();
        /*if(account.getSummaries() != null && account.getSummaries().size() !=0) {
            for(TrialsSummary trialSummary : account.getSummaries()) {
                 if(trialSummary.getId_trials_summary() != trialId) {
                     account.getSummaries().add(summary);
                     account = accountProfileRepository.save(account);
                 }
                break;
            }
        } */
            account.getSummaries().add(summary);
            account = accountProfileRepository.save(account);

        LOG.info("trial summary :{}", account);
        return mapper.writeValueAsString(account);
    }
    
    @PostMapping(value = "/updateTrialSummary", headers = "Accept=application/json")
    public String userFavouriteTrials(@RequestBody String csv) throws JsonProcessingException {
        
        return "Action Performed";
    }
}
