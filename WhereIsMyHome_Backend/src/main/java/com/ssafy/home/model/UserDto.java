package com.ssafy.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    String id;
    String pwd;
    String name;
    String email;
    String phone;
    
}
