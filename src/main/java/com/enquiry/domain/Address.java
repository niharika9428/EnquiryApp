package com.enquiry.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addressId")
	private Long addressId;

	@Column(name = "detail")
	private String detail;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@Column(name = "zip")
	private Integer zip;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Contact> contactList;

	public Address(Long addressId) {
		this.addressId = addressId;
	}

	public Address(String detail) {
		this.detail = detail;
	}

	public Address(String detail, String city, String country, Integer zip) {
		this.detail = detail;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}
	

}
