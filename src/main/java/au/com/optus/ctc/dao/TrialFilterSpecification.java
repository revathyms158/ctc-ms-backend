package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.TrialsSummary;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author revathyms
 */
public class TrialFilterSpecification {

    public static Specification<TrialsSummary> hasSpreadToOtherParts(String spreadToOtherParts) {
        return (trialsSummaryRoot, cq, cb) -> cb.like(trialsSummaryRoot.get("spreadToOtherParts"), "%" + spreadToOtherParts + "%");
    }

    public static Specification<TrialsSummary> withSex(String gender) {
        return (trialsSummaryRoot, cq, cb) -> cb.like(trialsSummaryRoot.get("Sex"), "%" + gender + "%");
    }

    public static Specification<TrialsSummary> hasPmp(String pmp) {
        return (trialsSummaryRoot, cq, cb) -> cb.like(trialsSummaryRoot.get("pmp"), "%" + pmp + "%");
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
