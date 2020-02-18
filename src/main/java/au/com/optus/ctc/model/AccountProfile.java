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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;
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

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns  =@JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    @JsonProperty
    private Set<Role> roles;

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


    public String getEmailAddress() {
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
    }

    @Override
    public String toString() {
        return "AccountProfile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
                + ", gender=" + gender + ", dob=" + dob + ", emailAddress=" + emailAddress + ", postCode=" + postCode
                + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
    }
}
