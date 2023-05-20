package com.ssafy.home.user.model;

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
    String address;
    String phone;
}
