package com.ssafy.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AptDto {
	private String aptCode;
	private String buildYear;
	private String roadName;
	private String dong;
	private String dongCode;
	private String apartmentName;
    private double lng;
    private double lat;
}
