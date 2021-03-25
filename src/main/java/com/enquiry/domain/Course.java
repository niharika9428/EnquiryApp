package com.enquiry.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "courseId")
	private Long courseId;
	@Column(name = "name")
	private String name;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "fees")
	private Double fees;

	@JoinColumn(name = "instituteId", referencedColumnName = "instituteId")
	@ManyToOne
	private Institute institute;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<EnquiryCourse> enquiryCourseList;

	public Course(Long courseId) {
		this.courseId = courseId;
	}

	public Course(String name, Double fees, Institute institute) {
		this.name = name;
		this.fees = fees;
		this.institute = institute;
	}
}
