package com.linuss.security.demo.springsecurityauthnauthz.request;

import com.linuss.security.demo.springsecurityauthnauthz.validation.PasswordConfirmed;
import com.linuss.security.demo.springsecurityauthnauthz.validation.PasswordPolicy;
import com.linuss.security.demo.springsecurityauthnauthz.validation.UniqueEmail;
import com.linuss.security.demo.springsecurityauthnauthz.validation.UniqueUsername;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@PasswordConfirmed
public class UserRegisterRequest {

	@NotEmpty(message = "Please enter your first name")
	private String firstName;

	@NotEmpty(message = "Please enter your last name")
	private String lastName;

	@UniqueUsername
	private String username;

	@UniqueEmail
	@Email(message = "Email is not valid")
	private String email;

	@NotEmpty(message = "Please enter in a password")
	@PasswordPolicy
	private String password;

	@NotEmpty(message = "Please enter your password")
	private String confirmPassword;
}
