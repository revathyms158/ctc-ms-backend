package au.com.optus.ctc.model;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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

	@OneToOne
	@JoinColumn(name="user_trial_condition")
	private TrialCondition condition;

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
	}
}
