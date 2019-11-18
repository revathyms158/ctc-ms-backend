package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.TrialsSummary;
import org.springframework.data.jpa.domain.Specification;

import static au.com.optus.ctc.model.CTCConstants.GENDER;
import static au.com.optus.ctc.model.CTCConstants.HAS_SPREAD_TO_OTHER_PARTS;
import static au.com.optus.ctc.model.CTCConstants.PMP;

/**
 * @author revathyms
 */
public class TrialFilterSpecification {

    public static Specification<TrialsSummary> hasSpreadToOtherParts(String spreadToOtherParts) {
        return (trialsSummaryRoot, cq, cb) ->
                cb.like(trialsSummaryRoot.get(HAS_SPREAD_TO_OTHER_PARTS), "%" + spreadToOtherParts + "%");
    }

    public static Specification<TrialsSummary> withGender(String gender) {
        return (trialsSummaryRoot, cq, cb) -> cb.like(trialsSummaryRoot.get(GENDER), "%" + gender + "%");
    }

    public static Specification<TrialsSummary> hasPmp(String pmp) {
        return (trialsSummaryRoot, cq, cb) -> cb.like(trialsSummaryRoot.get(PMP), "%" + pmp + "%");
    }

    public static Specification<TrialsSummary> hasAge(int age) {
        return (trialsSummaryRoot, cq, cb) -> cb.le(trialsSummaryRoot.get("age"), 18);
    }

    public static Specification<TrialsSummary> hasTumourSize(int size) {
        return (trialsSummaryRoot, cq, cb) -> cb.le(trialsSummaryRoot.get("tumourSize"), size);
    }

    public static Specification<TrialsSummary> hasNodeNumber(String nodeNumber) {
        return (trialsSummaryRoot, cq, cb) -> cb.like(trialsSummaryRoot.get("nodeNumber"), "%" + nodeNumber + "%");
    }
}
