package au.com.optus.ctc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by optus on 12/3/20.
 */

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TrialsSpecificParams {

    private Long userId;
    private Long trialId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTrialId() {
        return trialId;
    }

    public void setTrialId(Long trialId) {
        this.trialId = trialId;
    }
}
