package com.enquiry.dto;

import com.enquiry.domain.Enquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryCommand {

	Enquiry enquiry;
	Long[] courseIds;
}
