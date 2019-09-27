package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.TrialsSummaryRepository;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author revathyms
 */

@CrossOrigin(origins = {"http://localhost:4200"})
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

    @PostMapping(value = "/matchingTrials", headers = "Accept=application/json")
    public String fetchMatchingTrials(@RequestBody TrialCondition condition) throws JsonProcessingException {
        LOG.info("inside fetchMatchingTrials():: condition ->{}", condition);
        /*TrialCondition condition1 = new TrialCondition();
        condition1.setPmp(AnswerValueEnum.YES.value());
        condition1.setBRCAMutation(AnswerValueEnum.NO.value());
        condition1.setEcog(3);
        condition1.setER(AnswerValueEnum.NEGATIVE.value());
        condition1.setPR(AnswerValueEnum.NEGATIVE.value());
        condition1.setHER2(AnswerValueEnum.NEGATIVE.value());
        condition1.setSpreadToOtherParts(AnswerValueEnum.NO.value());
        condition1.setNodalStatus(AnswerValueEnum.NOT_SURE.value());
        condition1.setStage(2);
        condition1.setTumourSize("15");
        condition1.setNodeNumber("1-3");
        condition1.setSex(GenderEnum.NA.value());
        condition1.setAge(24);
        condition1.setNodeNumber("1-3");
        System.out.println("value {}" +mapper.writeValueAsString(condition1));*/
        String trialCondition = "{\"pmp\":\"Y\",\"nodalStatus\":\"Y/N\",\"spreadToOtherParts\":\"N\",\"tumourSize\":15,\"ecog\":3,\"nodeNumber\":\"1-3\",\"stage\":2,\"her2\":\"NEG\",\"er\":\"NEG\",\"pr\":\"NEG\",\"brcamutation\":\"N\"}";
       /* if (condition != null) {
       //value {}{"pmp":"Y","age":24,"postCode":null,"sex":"F,M","nodalStatus":"Y/N","spreadToOtherParts":"N","tumourSize":"15","ecog":3,"nodeNumber":"1-3","stage":2,"brcamutation":"N","er":"NEG","pr":"NEG","her2":"NEG"}
        }*/
        List<TrialsSummary> result = new ArrayList<>();
        if (StringUtils.isBlank(condition.getGender())) {
            condition.setGender(GenderEnum.NA.value());
            result = filterService.getMatchingTrials(condition);
        } else {
            result = filterService.getMatchingTrials(condition);
        }
        LOG.info("result :{}", result);
        return  mapper.writeValueAsString(result);
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
