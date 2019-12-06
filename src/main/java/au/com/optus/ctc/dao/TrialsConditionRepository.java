package au.com.optus.ctc.dao;

import au.com.optus.ctc.model.TrialCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by optus on 24/10/19.
 */


@Repository
public interface TrialsConditionRepository extends JpaRepository<TrialCondition, Long> {

}