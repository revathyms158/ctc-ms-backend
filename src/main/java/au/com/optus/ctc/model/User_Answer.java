/*
package au.com.optus.ctc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

*/
/**
 * Created by optus on 30/10/19.
 *//*


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"id"}, allowGetters = true)
@Entity
@Table(name = "user_answer")
public class User_Answer {

    @Setter(AccessLevel.PROTECTED)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user_answer_key")
    private Long id_user_answer_key;

    @NonNull
    @Column(name = "answered_value")
    private String answer;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private AccountProfile user;

    @OneToOne
    @JoinColumn(name="ques_id")
    private Questionnaires questionnaires;

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
}
*/
