package au.com.optus.ctc.service;

import au.com.optus.ctc.model.TrialCondition;
import au.com.optus.ctc.model.TrialsSummary;

import java.util.List;

/**
 * @author revathyms
 */
public interface TrialFilterServiceIF {

    List<TrialsSummary> getMatchingTrials(TrialCondition condition);
}
