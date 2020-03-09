package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author revathyms
 */

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "Questions")
public class TrialCondition {

    @Setter(AccessLevel.PROTECTED)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Long quesId;

/*    @OneToOne
    @JoinColumn(name="account_id")
    private AccountProfile account;*/

    @Column(name = "pmp")
    @JsonProperty
    private String pmp;

    @Column(name = "age")
    @JsonProperty
    private int age;

    @Column(name = "postCode")
    @JsonProperty
    private String postCode;

    @Column(name = "Sex")
    @JsonProperty
    private String Sex;

    @Column(name = "nodalStatus")
    @JsonProperty
    private String nodalStatus;

    @Column(name = "spreadToOtherParts")
    @JsonProperty
    private String spreadToOtherParts;

    @Column(name = "tumourSize")
    @JsonProperty
    private String tumourSize;

    @Column(name = "ecog")
    @JsonProperty
    private int ecog;

    @Column(name = "ER")
    @JsonProperty
    private String ER;

    @Column(name = "PR")
    @JsonProperty
    private String PR;

    @Column(name = "HER2")
    @JsonProperty
    private String HER2;

    @Column(name = "nodeNumber")
    @JsonProperty
    private String NodeNumber;

    @Column(name = "stage")
    @JsonProperty
    private int stage;

    @ElementCollection
    @Column(name = "BRCAMutation")
    @JsonProperty
    private List<String> BRCAMutation;

    @Column(name = "initialDiagnosis")
    @JsonProperty
    private String diagnosis;

    @Column(name = "tumourType")
    @JsonProperty
    private String tumorType;

    private Long accountUserId;


    @ElementCollection
    @Column(name = "Research_interest")
    @JsonProperty
    private List<String> researchInterest;

    @ElementCollection
    @Column(name = "Symptoms")
    @JsonProperty
    private List<String> Symptoms;

    /*@ElementCollection
    @Column(name = "breastCancerSpreadToOtherParts")
    @JsonProperty
    private List<String> breastCancerSpreadToOtherParts;*/

    @Column(name = "e_Surgery")
    @JsonProperty
    private String earlySurgery;


    @Column(name = "e_Hormones")
    @JsonProperty
    private String earlyHormones;


    @Column(name = "e_Chemotherapy")
    @JsonProperty
    private String earlyChemotherapy;


    @Column(name = "e_HER2_Therapy")
    @JsonProperty
    private String earlyHER2Therapy;


    @Column(name = "e_CDK_Inhibitor")
    @JsonProperty
    private String earlyCDKInhibitor;


    @Column(name = "e_PARP_Inhibitor")
    @JsonProperty
    private String earlyPARPInhibitor;


    @Column(name = "e_Immunotherapy")
    @JsonProperty
    private String earlyImmunotherapy;


    @Column(name = "e_Radiotherapy")
    @JsonProperty
    private String earlyRadiotherapy;


    @Column(name = "adv_Chemotherapy")
    @JsonProperty
    private String advancedChemotherapy;


    @Column(name = "adv_Hormones")
    @JsonProperty
    private String advancedHormones;

    @Column(name = "adv_Radiotherapy")
    @JsonProperty
    private String advancedRadiotherapy;


    @Column(name = "adv_Surgery")
    @JsonProperty
    private String advancedSurgery;


    @Column(name = "adv_CDK_Inhibitor")
    @JsonProperty
    private String advancedCDKInhibitor;


    @Column(name = "adv_HER2_Therapy")
    @JsonProperty
    private String advancedHER2Therapy;

    @Column(name = "adv_PARP_Inhibitor")
    @JsonProperty
    private String advancedPARPInhibitor;


    @Column(name = "adv_Immunotherapy")
    @JsonProperty
    private String advancedImmunotherapy;

    public Long getQuesId() {
        return quesId;
    }

    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    public String getPmp() {
        return pmp;
    }

    public void setPmp(String pmp) {
        this.pmp = pmp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getNodalStatus() {
        return nodalStatus;
    }

    public void setNodalStatus(String nodalStatus) {
        this.nodalStatus = nodalStatus;
    }

    public String getSpreadToOtherParts() {
        return spreadToOtherParts;
    }

    public void setSpreadToOtherParts(String spreadToOtherParts) {
        this.spreadToOtherParts = spreadToOtherParts;
    }

    public String getTumourSize() {
        return tumourSize;
    }

    public void setTumourSize(String tumourSize) {
        this.tumourSize = tumourSize;
    }

    public int getEcog() {
        return ecog;
    }

    public void setEcog(int ecog) {
        this.ecog = ecog;
    }

    public String getER() {
        return ER;
    }

    public void setER(String ER) {
        this.ER = ER;
    }

    public String getPR() {
        return PR;
    }

    public void setPR(String PR) {
        this.PR = PR;
    }

    public String getHER2() {
        return HER2;
    }

    public void setHER2(String HER2) {
        this.HER2 = HER2;
    }

    public String getNodeNumber() {
        return NodeNumber;
    }

    public void setNodeNumber(String nodeNumber) {
        NodeNumber = nodeNumber;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public List<String> getBRCAMutation() {
        return BRCAMutation;
    }

    public void setBRCAMutation(List<String> BRCAMutation) {
        this.BRCAMutation = BRCAMutation;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTumorType() {
        return tumorType;
    }

    public void setTumorType(String tumorType) {
        this.tumorType = tumorType;
    }

    public Long getAccountUserId() {
        return accountUserId;
    }

    public void setAccountUserId(Long accountUserId) {
        this.accountUserId = accountUserId;
    }

    public List<String> getResearchInterest() {
        return researchInterest;
    }

    public void setResearchInterest(List<String> researchInterest) {
        this.researchInterest = researchInterest;
    }

    public List<String> getSymptoms() {
        return Symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        Symptoms = symptoms;
    }

    public String getEarlySurgery() {
        return earlySurgery;
    }

    public void setEarlySurgery(String earlySurgery) {
        this.earlySurgery = earlySurgery;
    }

    public String getEarlyHormones() {
        return earlyHormones;
    }

    public void setEarlyHormones(String earlyHormones) {
        this.earlyHormones = earlyHormones;
    }

    public String getEarlyChemotherapy() {
        return earlyChemotherapy;
    }

    public void setEarlyChemotherapy(String earlyChemotherapy) {
        this.earlyChemotherapy = earlyChemotherapy;
    }

    public String getEarlyHER2Therapy() {
        return earlyHER2Therapy;
    }

    public void setEarlyHER2Therapy(String earlyHER2Therapy) {
        this.earlyHER2Therapy = earlyHER2Therapy;
    }

    public String getEarlyCDKInhibitor() {
        return earlyCDKInhibitor;
    }

    public void setEarlyCDKInhibitor(String earlyCDKInhibitor) {
        this.earlyCDKInhibitor = earlyCDKInhibitor;
    }

    public String getEarlyPARPInhibitor() {
        return earlyPARPInhibitor;
    }

    public void setEarlyPARPInhibitor(String earlyPARPInhibitor) {
        this.earlyPARPInhibitor = earlyPARPInhibitor;
    }

    public String getEarlyImmunotherapy() {
        return earlyImmunotherapy;
    }

    public void setEarlyImmunotherapy(String earlyImmunotherapy) {
        this.earlyImmunotherapy = earlyImmunotherapy;
    }

    public String getEarlyRadiotherapy() {
        return earlyRadiotherapy;
    }

    public void setEarlyRadiotherapy(String earlyRadiotherapy) {
        this.earlyRadiotherapy = earlyRadiotherapy;
    }

    public String getAdvancedChemotherapy() {
        return advancedChemotherapy;
    }

    public void setAdvancedChemotherapy(String advancedChemotherapy) {
        this.advancedChemotherapy = advancedChemotherapy;
    }

    public String getAdvancedHormones() {
        return advancedHormones;
    }

    public void setAdvancedHormones(String advancedHormones) {
        this.advancedHormones = advancedHormones;
    }

    public String getAdvancedRadiotherapy() {
        return advancedRadiotherapy;
    }

    public void setAdvancedRadiotherapy(String advancedRadiotherapy) {
        this.advancedRadiotherapy = advancedRadiotherapy;
    }

    public String getAdvancedSurgery() {
        return advancedSurgery;
    }

    public void setAdvancedSurgery(String advancedSurgery) {
        this.advancedSurgery = advancedSurgery;
    }

    public String getAdvancedCDKInhibitor() {
        return advancedCDKInhibitor;
    }

    public void setAdvancedCDKInhibitor(String advancedCDKInhibitor) {
        this.advancedCDKInhibitor = advancedCDKInhibitor;
    }

    public String getAdvancedHER2Therapy() {
        return advancedHER2Therapy;
    }

    public void setAdvancedHER2Therapy(String advancedHER2Therapy) {
        this.advancedHER2Therapy = advancedHER2Therapy;
    }

    public String getAdvancedPARPInhibitor() {
        return advancedPARPInhibitor;
    }

    public void setAdvancedPARPInhibitor(String advancedPARPInhibitor) {
        this.advancedPARPInhibitor = advancedPARPInhibitor;
    }

    public String getAdvancedImmunotherapy() {
        return advancedImmunotherapy;
    }

    public void setAdvancedImmunotherapy(String advancedImmunotherapy) {
        this.advancedImmunotherapy = advancedImmunotherapy;
    }
}
