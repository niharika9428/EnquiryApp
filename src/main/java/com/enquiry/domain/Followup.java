package com.enquiry.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "followup")
public class Followup implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "followupId")
	private Long followupId;

	@Column(name = "doe")
	@Temporal(TemporalType.TIMESTAMP)
	private Date doe;

	@Column(name = "detail")
	private String detail;

	@JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
	@ManyToOne
	private Enquiry enquiry;
	
	public Followup(Long followupId, Date doe, String detail) {
        this.followupId = followupId;
        this.doe = doe;
        this.detail = detail;
    }


}
