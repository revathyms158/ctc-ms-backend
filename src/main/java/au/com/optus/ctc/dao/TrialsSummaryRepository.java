package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.TrialsSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author revathyms
 */
@Repository
public interface TrialsSummaryRepository extends JpaRepository<TrialsSummary, Long>, JpaSpecificationExecutor<TrialsSummary> {
    public List<TrialsSummary> findByName(String name);
}
