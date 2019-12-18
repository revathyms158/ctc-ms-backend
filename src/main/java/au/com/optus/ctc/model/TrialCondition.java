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
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"id"}, allowGetters = true)
@Entity
@Table(name = "trial_condition")
public class TrialCondition {

    @Setter(AccessLevel.PROTECTED)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_trials_condition")
    private Long id;

    @OneToOne
    @JoinColumn(name="id_users")
    private AccountProfile account;

    @NonNull
    @Column(name = "pmp")
        private String pmp;
    //private int age;

    @NonNull
    @Column(name = "postCode")
    private String postCode;

    @NonNull
    @Column(name = "gender")
    private String gender;

    @NonNull
    @Column(name = "nodalStatus")
    private String nodalStatus;

    @NonNull
    @Column(name = "spreadToOtherParts")
    private String spreadToOtherParts;

    @NonNull
    @Column(name = "tumourSize")
    private String tumourSize;

    @NonNull
    @Column(name = "ecog")
    private int ecog;

    @NonNull
    @Column(name = "ER")
    private String ER;

    @NonNull
    @Column(name = "PR")
    private String PR;

    @NonNull
    @Column(name = "HER2")
    private String HER2;

    @NonNull
    @Column(name = "nodeNumber")
    private String nodeNumber;

    @NonNull
    @Column(name = "stage")
    private int stage;

    @NonNull
    @Column(name = "BRCAMutation")
    private String BRCAMutation;

    @NonNull
    @Column(name = "initialDiagnosis", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.PROTECTED)
    @CreatedDate
    private Date initialDiagnosis;

    @NonNull
    @Column(name = "tumourType")
    private String tumourType;


}
