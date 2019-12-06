package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author revathyms
 */
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(value = { "id", "createdOn", "updatedOn" }, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "user_details", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class AccountProfile {
	public AccountProfile() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "id_users")
	private String id;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "User_Trials_Summary",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "trial_summary_id") }
	)
	private Set<TrialsSummary> summary;

	@NonNull
	@Column(name = "first_name")
	@JsonProperty
	private String firstName;

	@NonNull
	@Column(name = "last_name")
	@JsonProperty
	private String lastName;

	@NonNull
	@Column(name = "age")
	@JsonProperty
	private int age;

	@NonNull
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	@JsonProperty
	private GenderEnum gender;

	/*
	 * @NonNull
	 * 
	 * @Column(name = "role") private String role;
	 */

	@NonNull
	@Column(name = "dob")
	@JsonProperty
	private Date dob;

	/*
	 * @NonNull
	 * 
	 * @Column(name = "contact_number") private String contactNumber;
	 */
	@NonNull
	@Column(name = "email", unique = true)
	@JsonProperty
	private String emailAddress;

	@NonNull
	@Column(name = "address")
	@JsonProperty
	private String postCode;

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

	@Override
	public String toString() {
		return "AccountProfile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + ", emailAddress=" + emailAddress + ", postCode=" + postCode
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<TrialsSummary> getSummary() {
		return summary;
	}

	public void setSummary(Set<TrialsSummary> summary) {
		this.summary = summary;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
