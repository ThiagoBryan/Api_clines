package br.com.caelum.clines.api.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersView {
    
	private Long id;
	private String name;
	private String email;
	private String password;
	private String infoUsers;

}
