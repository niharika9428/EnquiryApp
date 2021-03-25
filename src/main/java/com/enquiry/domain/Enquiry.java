package com.enquiry.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "enquiry")
public class Enquiry implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enquiryId")
    private Long enquiryId;
    
    @Column(name = "doe")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date doe;
    @Column(name = "nextCallDate")
    @Temporal(TemporalType.DATE)
    private Date nextCallDate;
    @Column(name = "remark")
    private String remark;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "committedFees")
    private Double committedFees;
    @Column(name = "lastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    
    @Transient
    private List<Followup> followupList;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    
    @Transient
    private List<EnquiryCourse> enquiryCourseList;

    @JoinColumn(name = "contactId", referencedColumnName = "contactId")
    @ManyToOne
    private Contact contact;
    
    @JoinColumn(name = "instituteId", referencedColumnName = "instituteId")
    @ManyToOne
    private Institute institute;
    @JoinColumn(name = "enquirySourceId", referencedColumnName = "enquirySourceId")
    @ManyToOne
    private EnquirySource enquirySource;
    
    public Enquiry(Long enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Enquiry(Long enquiryId, String remark) {
        this.enquiryId = enquiryId;
        this.remark = remark;
    }
    
}
