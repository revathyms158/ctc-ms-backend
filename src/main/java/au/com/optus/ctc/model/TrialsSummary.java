package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "summary")
    private Set<AccountProfile> account;

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

    //@NonNull
   // @Column(name = "age")
    //private int age;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<AccountProfile> getAccount() {
        return account;
    }

    public void setAccount(Set<AccountProfile> account) {
        this.account = account;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getTrialGovRegId() {
        return trialGovRegId;
    }

    public void setTrialGovRegId(String trialGovRegId) {
        this.trialGovRegId = trialGovRegId;
    }

    public String getAnzctrRegId() {
        return anzctrRegId;
    }

    public void setAnzctrRegId(String anzctrRegId) {
        this.anzctrRegId = anzctrRegId;
    }

    public String getBct() {
        return bct;
    }

    public void setBct(String bct) {
        this.bct = bct;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getPmp() {
        return pmp;
    }

    public void setPmp(String pmp) {
        this.pmp = pmp;
    }

    public int getTumourSize() {
        return tumourSize;
    }

    public void setTumourSize(int tumourSize) {
        this.tumourSize = tumourSize;
    }

    public String getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(String nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public String getSpreadToOtherParts() {
        return spreadToOtherParts;
    }

    public void setSpreadToOtherParts(String spreadToOtherParts) {
        this.spreadToOtherParts = spreadToOtherParts;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
