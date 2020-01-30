package au.com.optus.ctc.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

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

    /*@OneToOne(mappedBy="condition")
    private AccountProfile account;*/

    @OneToOne
    @JoinColumn(name="account_id")
    private AccountProfile account;

    @Column(name = "pmp")
    private String pmp;

    @Column(name = "age")
    private int age;

    @Column(name = "postCode")
    private String postCode;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nodalStatus")
    private String nodalStatus;

    @Column(name = "spreadToOtherParts")
    private String spreadToOtherParts;

    @Column(name = "tumourSize")
    private String tumourSize;

    @Column(name = "ecog")
    private int ecog;

    @Column(name = "ER")
    private String ER;

    @Column(name = "PR")
    private String PR;

    @Column(name = "HER2")
    private String HER2;

    @Column(name = "nodeNumber")
    private String nodeNumber;

    @Column(name = "stage")
    private int stage;

    @Column(name = "BRCAMutation")
    private String BRCAMutation;

    @Column(name = "initialDiagnosis")
    private Date initialDiagnosis;

    @Column(name = "tumourType")
    private String tumourType;

    public Long getQuesId() {
        return quesId;
    }

    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    public AccountProfile getAccount() {
        return account;
    }

    public void setAccount(AccountProfile account) {
        this.account = account;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return nodeNumber;
    }

    public void setNodeNumber(String nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getBRCAMutation() {
        return BRCAMutation;
    }

    public void setBRCAMutation(String BRCAMutation) {
        this.BRCAMutation = BRCAMutation;
    }

    public Date getInitialDiagnosis() {
        return initialDiagnosis;
    }

    public void setInitialDiagnosis(Date initialDiagnosis) {
        this.initialDiagnosis = initialDiagnosis;
    }

    public String getTumourType() {
        return tumourType;
    }

    public void setTumourType(String tumourType) {
        this.tumourType = tumourType;
    }
}
