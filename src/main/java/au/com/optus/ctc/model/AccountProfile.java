package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.DocFlavor.STRING;

import java.util.Date;

/**
 * @author revathyms
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "id", "createdOn", "updatedOn" }, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "user_details")
public class AccountProfile {

	@Setter(AccessLevel.PROTECTED)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_users")
	private Long id;

	@NonNull
	@Column(name = "first_name")
	private String firstName;

	@NonNull
	@Column(name = "last_name")
	private String lastName;

	@NonNull
	@Column(name = "age")
	private int age;

	@NonNull
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private GenderEnum gender;

	/*@NonNull
	@Column(name = "role")
	private String role;*/

	@NonNull
	@Column(name = "dob")
	private Date dob;

	/*@NonNull
	@Column(name = "contact_number")
	private String contactNumber;*/

	@NonNull
	@Column(name = "email")
	private String emailAddress;

	@NonNull
	@Column(name = "address")
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

}
