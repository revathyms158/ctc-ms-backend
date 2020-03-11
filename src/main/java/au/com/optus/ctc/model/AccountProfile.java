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
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.Date;
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


    @Column(name = "age")
    @JsonProperty
    private int age;


    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @JsonProperty
    private GenderEnum gender;


    @Column(name = "dob")
    @JsonProperty
    private Date dob;


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

  /*  @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(name = "user_summary_id")
    private List<TrialsSummary> summaries;*/


    @ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinTable(name = "USER_TrialsSummary",
            joinColumns = { @JoinColumn(name = "User_ID") },
            inverseJoinColumns = { @JoinColumn(name = "TrialSummary_ID") })
    private List<TrialsSummary> summaries = new ArrayList<TrialsSummary>();

    @Column(name = "created_on", nullable = false, updatable = false)
// @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.PROTECTED)
    @CreatedDate
    private Date createdOn;

    @Column(name = "updated_on", nullable = false)
// @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.PROTECTED)
    @LastModifiedDate
    private Date updatedOn;

    public TrialCondition getCondition() {
        return condition;
    }

    public void setCondition(TrialCondition condition) {
        this.condition = condition;
    }

    public List<TrialsSummary> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<TrialsSummary> summaries) {
        this.summaries = summaries;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    /*public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    @Override
    public String toString() {
        return "AccountProfile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
                + ", gender=" + gender + ", dob=" + dob + ", emailAddress=" + emailAddress + ", postCode=" + postCode
                + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
    }
}
