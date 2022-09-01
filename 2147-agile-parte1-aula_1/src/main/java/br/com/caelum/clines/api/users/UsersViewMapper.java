package br.com.caelum.clines.api.users;

import org.springframework.stereotype.Component;

import br.com.caelum.clines.shared.domain.Users;
import br.com.caelum.clines.shared.infra.Mapper;

@Component
public class UsersViewMapper implements Mapper<Users, UsersView> {

	

	@Override
	public UsersView map(Users users) {
		return new UsersView(users.getId(), users.getName(), users.getEmail(), users.getPassword(), users.getInfoUsers());
	}

}
