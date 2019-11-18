package au.com.optus.ctc.service;

import au.com.optus.ctc.dao.TrialFilterSpecification;
import au.com.optus.ctc.dao.TrialsSummaryRepository;
import au.com.optus.ctc.model.CTCConstants;
import au.com.optus.ctc.model.TrialCondition;
import au.com.optus.ctc.model.TrialsSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author revathyms
 */
@Service
public class TrialFilterServiceImpl implements TrialFilterServiceIF {

    @Autowired
    TrialsSummaryRepository repository;


    @Override
    public List<TrialsSummary> getMatchingTrials(TrialCondition condition) {
        System.out.println("inside getMatchingTrials()");
        if (!condition.getTumourSize().equalsIgnoreCase(CTCConstants.CONDITION_UNKNOWN)) {

            return repository.findAll(TrialFilterSpecification.withGender(condition.getGender())
                    .and(TrialFilterSpecification.hasSpreadToOtherParts(condition.getSpreadToOtherParts()))
                    .and(TrialFilterSpecification.hasPmp(condition.getPmp()))
                    .and(TrialFilterSpecification.hasAge(condition.getAge()))
                    .and(TrialFilterSpecification.hasTumourSize(Integer.parseInt(condition.getTumourSize())))
                    .and(TrialFilterSpecification.hasNodeNumber(condition.getNodeNumber())));
        } else {
            return repository.findAll(TrialFilterSpecification.withGender(condition.getGender())
                    .and(TrialFilterSpecification.hasSpreadToOtherParts(condition.getSpreadToOtherParts()))
                    .and(TrialFilterSpecification.hasPmp(condition.getPmp()))
                    .and(TrialFilterSpecification.hasAge(condition.getAge()))
                    .and(TrialFilterSpecification.hasNodeNumber(condition.getNodeNumber())));
        }
    }
}
