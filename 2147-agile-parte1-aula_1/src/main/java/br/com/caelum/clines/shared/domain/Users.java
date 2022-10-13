package br.com.caelum.clines.shared.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name= "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;
	
	private String email;
	
	@NotNull
	private String password;
	
	private String infoUsers;
	
	
	public Users (String name, String email, String password, String infoUsers) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.infoUsers = infoUsers;
		
	}

	public Users(Long id, @NotNull String name, String email, @NotNull String password, String infoUsers) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.infoUsers = infoUsers;
	}

}
