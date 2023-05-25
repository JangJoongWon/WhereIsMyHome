package com.ssafy.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteDto {
	private String idx;
    private String sidoName;
    private String gugunName;
    private String dongName;
	private String aptCode;
	private String userid;
	private String apartmentName;
}
