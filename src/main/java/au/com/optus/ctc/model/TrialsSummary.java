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
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@AllArgsConstructor
@JsonIgnoreProperties(value = {"id", "createdOn", "updatedOn"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "trials_summary")
public class TrialsSummary {
    @Setter(AccessLevel.PROTECTED)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_trials_summary")
    private Long id;

    @NonNull
    @Column(name = "stage")
    private String stage;

    @NonNull
    @Column(name = "subtype")
    private String subtype;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Lob
    @Column(name = "summary")
    private String summary;

    @NonNull
    @Column(name = "phase")
    private String phase;

    @NonNull
    @Column(name = "clinical_trialgov")
    private String trialGovRegId;

    @NonNull
    @Column(name = "anzctr")
    private String anzctrRegId;

    @NonNull
    @Column(name = "bct")
    private String bct;

    @NonNull
    @Column(name = "location")
    private String location;

    @NonNull
    @Column(name = "postcode")
    private String postCode;

    @NonNull
    @Column(name = "gender")
    private String gender;

    @NonNull
    @Column(name = "pmp")
    private String pmp;

    @NonNull
    @Column(name = "age")
    private int age;

    @NonNull
    @Column(name = "tumour_size")
    private int tumourSize;

    @NonNull
    @Column(name = "node_number")
    private String nodeNumber;

    @NonNull
    @Column(name = "is_spread_to_other_parts")
    private String spreadToOtherParts;

    @Column(name = "created_on", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.PROTECTED)
    @CreatedDate
    private Date createdOn;

    @Column(name = "updated_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.PROTECTED)
    @LastModifiedDate
    private Date updatedOn;
}
