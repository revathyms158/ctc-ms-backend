package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.dao.TrialsSummaryRepository;
import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.AnswerValueEnum;
import au.com.optus.ctc.model.CTCConstants;
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
    AccountProfileRepository profileRepository;


    @Autowired
    TrialFilterServiceIF filterService;

    @PostMapping(value = "/matchingTrials", headers = "Accept=application/json")
    public String fetchMatchingTrials(@RequestBody TrialCondition condition) throws JsonProcessingException {
        LOG.info("inside fetchMatchingTrials():: condition ->{}", condition);
        List<TrialsSummary> result = null;
        if (StringUtils.isNotBlank(condition.getUserId())) {

            Optional<AccountProfile> profile = profileRepository.findById(condition.getUserId());
            profile.get().getGender();
            if (StringUtils.isBlank(condition.getGender())) {
                condition.setGender(GenderEnum.NA.value());
            }
            if (StringUtils.isBlank(condition.getTumourSize())) {
                condition.setTumourSize(CTCConstants.CONDITION_UNKNOWN);
            }
            if (StringUtils.isBlank(condition.getNodeNumber())) {
                condition.setNodeNumber(CTCConstants.NODE_NUMBER_UNKNOWN);
            }
            if (StringUtils.isBlank(condition.getSpreadToOtherParts()) ||
                    StringUtils.equalsIgnoreCase(condition.getSpreadToOtherParts(), AnswerValueEnum.NOT_SURE.value())) {
                condition.setSpreadToOtherParts(AnswerValueEnum.NO.value());
                result = filterService.getMatchingTrials(condition);
            } else {
                result = filterService.getMatchingTrials(condition);
            }

        }
        LOG.info("result :{}", result);
        return mapper.writeValueAsString(result);
    }

    @GetMapping(value = "/savedTrials", headers = "Accept=application/json")
    public String fetchSavedTrials(/*@RequestBody AccountProfile profile*/) throws JsonProcessingException {

        return mapper.writeValueAsString(repository.findAll());
    }

    @PostMapping(value = "/removeTrials", headers = "Accept=application/json")
    public String fetchRemovedTrials(/*@RequestBody AccountProfile profile*/)  {

        return  null;
    }


}
