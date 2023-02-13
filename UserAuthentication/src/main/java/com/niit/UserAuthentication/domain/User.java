package com.niit.UserAuthentication.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    String email;
    String firstName;
    String lastName;
    String password;
    String usertype;
    String phoneNumber;
}
