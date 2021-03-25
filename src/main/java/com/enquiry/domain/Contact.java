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
@Table(name = "contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "contactId")
	private Long contactId;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@JoinColumn(name = "localAddress", referencedColumnName = "addressId")
	@ManyToOne
	private Address localAddress;

	@JoinColumn(name = "permanentAddress", referencedColumnName = "addressId")
	@ManyToOne
	private Address permanentAddress;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Enquiry> enquiryList;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Institute> instituteList;

	public Contact(Long contactId) {
        this.contactId = contactId;
    }

    public Contact(String name, String email, String phone, Address localAddress, Address permanentAddress) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.localAddress = localAddress;
        this.permanentAddress = permanentAddress;
    }
    
}
