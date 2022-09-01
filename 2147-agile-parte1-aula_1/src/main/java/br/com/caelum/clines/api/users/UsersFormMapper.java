package br.com.caelum.clines.api.users;

import org.springframework.stereotype.Component;

import br.com.caelum.clines.shared.domain.Users;
import br.com.caelum.clines.shared.infra.Mapper;

@Component
public class UsersFormMapper implements Mapper <UsersForm, Users> {

	@Override
	public Users map(UsersForm source) {
		
		return new Users(source.getName(), source.getEmail(), source.getPassword(), source.getInfoUsers());
	}

	
}
