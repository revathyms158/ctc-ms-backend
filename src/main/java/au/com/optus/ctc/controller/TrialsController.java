package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.dao.TrialsConditionRepository;
import au.com.optus.ctc.dao.TrialsSummaryRepository;
import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.AnswerValueEnum;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author revathyms
 */

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping(value = "/api/ctc/trials")
public class TrialsController {

    private static final Logger LOG = LoggerFactory.getLogger(TrialsController.class);

    @Autowired
    ObjectMapper mapper;

    @Autowired
    AccountProfileRepository accrepo;

    @Autowired
    TrialsSummaryRepository repository;
    @Autowired
    TrialsConditionRepository trialsConditionRepository;

    @Autowired
    TrialFilterServiceIF filterService;

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
        return mapper.writeValueAsString(result);
/*
        if (condition != null) {
            mapper.writeValueAsString(trialsConditionRepository.save(condition));
        }
        return mapper.writeValueAsString(filterService.getMatchingTrials(condition));*/
    }

    @GetMapping(value = "/userTrialConditions/{id}", headers = "Accept=application/json")
    public String fetchSavedTrials( @PathVariable("id") Long id) throws JsonProcessingException {
        TrialCondition condition = trialsConditionRepository.findById(id).get();
        return mapper.writeValueAsString(condition);
    }

    @PostMapping(value = "/removeTrials", headers = "Accept=application/json")
    public String fetchRemovedTrials(/*@RequestBody AccountProfile profile*/)  {

        return  null;
    }

}
