package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author revathyms
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class TrialCondition {

    private String pmp;
    private int age;
    private String postCode;
    private String gender;
    private String nodalStatus;
    private String spreadToOtherParts;
    private String tumourSize;
    private int ecog;
    private String ER;
    private String PR;
    private String HER2;
    private String nodeNumber;
    private int stage;
    private String BRCAMutation;
    private Date initialDiagnosis;
    private String tumourType;

}
