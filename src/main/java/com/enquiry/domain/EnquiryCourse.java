package com.enquiry.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "enquirycourse")
public class EnquiryCourse implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "enquiryCourseId")
	private Long enquiryCourseId;
	@JoinColumn(name = "courseId", referencedColumnName = "courseId")
	@ManyToOne
	private Course course;

	@JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
	@ManyToOne
	private Enquiry enquiry;

	public EnquiryCourse(Long enquiryCourseId) {
		this.enquiryCourseId = enquiryCourseId;
	}
}
