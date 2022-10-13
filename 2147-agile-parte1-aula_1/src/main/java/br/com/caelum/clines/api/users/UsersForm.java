package br.com.caelum.clines.api.users;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UsersForm {

//	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String infoUsers;

}
