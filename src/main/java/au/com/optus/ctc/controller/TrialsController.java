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

            if(account != null) {
                condition.setAccount(account.get());
            }
        }

        TrialCondition trials = trialsConditionRepository.save(condition);
        LOG.info("trial conditions :{}", trials);
        mapper.writeValueAsString(trialsConditionRepository.save(trials));
        return  mapper.writeValueAsString(result);
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/userList",  headers = "Accept=application/json")
    public String getAllUsersSavedTrials() throws JsonProcessingException {
        List<TrialCondition> condition = trialsConditionRepository.findAll();
        LOG.info("trials :{}", condition);
        return mapper.writeValueAsString(condition);
    }


    @PostMapping(value = "/removeUser/{quesId}", headers = "Accept=application/json")
    public String fetchRemovedTrials(@PathVariable final Long quesId)  {
        Optional<TrialCondition> condition = trialsConditionRepository.findById(quesId);
        if(condition!=null && condition.get().getAccountUserId()!= null) {
            Long id = condition.get().getAccountUserId();
            trialsConditionRepository.deleteById(quesId);
            accountProfileRepository.deleteById(id);
        }
        return "Trial is deleted";
    }

}
