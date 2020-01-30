package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.TrialCondition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by optus on 30/1/20.
 */
public interface TrialsConditionRepository extends JpaRepository<TrialCondition, Long>  {
}
