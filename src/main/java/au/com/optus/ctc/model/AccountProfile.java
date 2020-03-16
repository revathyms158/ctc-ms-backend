package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author revathyms
 */
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(value = { "id", "createdOn", "updatedOn" }, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class AccountProfile {
    public AccountProfile() {
      // TODO Auto-generated constructor stub
    }

    @Setter(AccessLevel.PROTECTED)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_users")
    private Long id;

    @NonNull
    @Column(name = "email", unique = true)
    @JsonProperty
    private String emailAddress;

    @NonNull
    @Column(name = "password")
    @JsonProperty
    private String password;


    @Column(name = "first_name")
    @JsonProperty
    private String firstName;


    @Column(name = "last_name")
    @JsonProperty
    private String lastName;


    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @JsonProperty
    private GenderEnum gender;


    public void setDob(String dob) {
        this.dob = dob;
    }

    @Column(name = "dob")
    @JsonProperty
    private String dob;


    @Column(name = "address")
    @JsonProperty
    private String postCode;

    @Column(name = "status")
    @JsonProperty
    private String status;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns  =@JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    @JsonProperty
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval=true)
    @JoinColumn(name="account_ques_id")
    private TrialCondition condition;


    @ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinTable(name = "USER_TrialsSummary",
            joinColumns = { @JoinColumn(name = "User_ID") },
            inverseJoinColumns = { @JoinColumn(name = "TrialSummary_ID") })
    private Set<TrialsSummary> summaries = new HashSet<>();

    @Column(name = "created_on", nullable = false, updatable = false)
    @Setter(AccessLevel.PROTECTED)
    private String createdOn;

    @Column(name = "updated_on", nullable = false)
    @Setter(AccessLevel.PROTECTED)
    private String updatedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public TrialCondition getCondition() {
        return condition;
    }

    public void setCondition(TrialCondition condition) {
        this.condition = condition;
    }

    public Set<TrialsSummary> getSummaries() {
        return summaries;
    }

    public void setSummaries(Set<TrialsSummary> summaries) {
        this.summaries = summaries;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "AccountProfile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob + ", emailAddress=" + emailAddress + ", postCode=" + postCode
                + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
    }
}
