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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

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
    private Long id_trials_summary;

   /* @NonNull
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


*/

    @NonNull
    @Column(name = "Cancer_Stage")
    private String stage;

    @NonNull
    @Column(name = "Cancer_Subtype")
    private String CancerSubtype;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "Summary")
    private String Summary;


    @NonNull
    @Column(name = "Phase")
    private String Phase;


    @NonNull
    @Column(name = "Location")
    private String Location;



    @NonNull
    @Column(name = "Post_Code")
    private String PostCode;


    @NonNull
    @Column(name = "ClinicalTrialsgov")
    private String ClinicalTrialsgov;


    @NonNull
    @Column(name = "ANZCTR")
    private String ANZCTR;


    @NonNull
    @Column(name = "BCT")
    private String BCT;


    @NonNull
    @Column(name = "age")
    private int age;



    @NonNull
    @Column(name = "Sex")
    private String Sex;

    @NonNull
    @Column(name = "PMP")
    private String pmp;

    @NonNull
    @Column(name = "ECOG")
    private String ecog;

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
    @Column(name = "Tumour_Size")
    private int tumourSize;

    @NonNull
    @Column(name = "Nodal_Status")
    private String NodalStatus;

    @NonNull
    @Column(name = "Node_Number")
    private String nodeNumber;

    @NonNull
    @Column(name = "Stage_cancer")
    private String Stagecancer;

    @NonNull
    @Column(name = "cancer_spread")
    private String spreadToOtherParts;

    @NonNull
    @Column(name = "BRCA_Mutation")
    private String BRCAMutation;

    @NonNull
    @Column(name = "e_Surgery")
    private String earlySurgery;

    @NonNull
    @Column(name = "e_Hormones")
    private String earlyHormonaltherapy;

    @NonNull
    @Column(name = "e_Chemotherapy")
    private String earlyChemotherapy;

    @NonNull
    @Column(name = "e_HER2_Therapy")
    private String earlyTargetedTxHERTherapy;

    @NonNull
    @Column(name = "e_CDK_Inhibitor")
    private String earlyTargetedTxCDKInhibitor;

    @NonNull
    @Column(name = "e_PARP_Inhibitor")
    private String earlyTargetedTxPARPInhibitor;

    @NonNull
    @Column(name = "e_Immunotherapy")
    private String earlyImmunotherapy;

    @NonNull
    @Column(name = "e_Radiotherapy")
    private String earlyRadiotherapy;


    @NonNull
    @Column(name = "adv_Surgery")
    private String advancedSurgery;

    @NonNull
    @Column(name = "adv_Hormones")
    private String advancedHormonaltherapy;

    @NonNull
    @Column(name = "adv_Chemotherapy")
    private String advancedChemotherapy;

    @NonNull
    @Column(name = "adv_HER2_Therapy")
    private String advancedTargetedTxHERTherapy;

    @NonNull
    @Column(name = "adv_CDK_Inhibitor")
    private String advancedTargetedTxCDKInhibitor;

    @NonNull
    @Column(name = "adv_PARP_Inhibitor")
    private String advancedTargetedTxPARPInhibitor;

    @NonNull
    @Column(name = "adv_Immunotherapy")
    private String advancedImmunotherapy;

    @NonNull
    @Column(name = "adv_Radiotherapy")
    private String advancedRadiotherapy;

    @NonNull
    @Column(name = "Placebo")
    private String Placebo;


    @NonNull
    @Column(name = "Hormone")
    private String Hormone;


    @NonNull
    @Column(name = "Chemo")
    private String Chemo;

    @NonNull
    @Column(name = "Radio")
    private String Radio;


    @NonNull
    @Column(name = "Surgery")
    private String Surgery;


    @NonNull
    @Column(name = "Immuno")
    private String Immuno;

    @NonNull
    @Column(name = "Targeted_Tx")
    private String TargetedTx;

    @NonNull
    @Column(name = "Targeted_Tx_HER2_Therapy")
    private String TargetedTxHER2Therapy;

    @NonNull
    @Column(name = "Targeted_Tx_CDK_Inhibitor")
    private String TargetedTxCDKInhibitor;


    @NonNull
    @Column(name = "Targeted_Tx_PARP_inhibitor")
    private String TargetedTxPARPInhibitor;


    @NonNull
    @Column(name = "Targeted_Tx_PIK3_Inhibitor")
    private String TargetedTxPIK3Inhibitor;


    @NonNull
    @Column(name = "Targeted_Tx_Akt_Inhibitor")
    private String TargetedTxAktInhibitor;

    @NonNull
    @Column(name = "Targeted_Tx_Other")
    private String TargetedTxOther;

    @NonNull
    @Column(name = "Prevention")
    private String Prevention;

    @NonNull
    @Column(name = "Imaging")
    private String Imaging;

    @NonNull
    @Column(name = "Complementary_Alternative_Medicine")
    private String ComplementaryAlternativeMedicine;

    @NonNull
    @Column(name = "Decision_Support")
    private String DecisionSupport;

    @NonNull
    @Column(name = "Genetics")
    private String Genetics;

    @NonNull
    @Column(name = "Lymph_oedema")
    private String LymphOedema;

    @NonNull
    @Column(name = "Activities_Exercise")
    private String ActivitiesExercise;

    @NonNull
    @Column(name = "Symptom_Management")
    private String Symptom;


    @NonNull
    @Column(name = "Education")
    private String Education;

    @NonNull
    @Column(name = "Survey_Questionnaire")
    private String SurveyQuestionnaire;

    @NonNull
    @Column(name = "Status")
    private String Status;


    @Column(name = "created_on", nullable = false, updatable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.PROTECTED)
    @CreatedDate
    private Date createdOn;

    @Column(name = "updated_on", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.PROTECTED)
    @LastModifiedDate
    private Date updatedOn;
}
