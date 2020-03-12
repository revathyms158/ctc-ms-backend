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
    private List<Long> trialIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getTrialIds() {
        return trialIds;
    }

    public void setTrialIds(List<Long> trialIds) {
        this.trialIds = trialIds;
    }
}
