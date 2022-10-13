package br.com.caelum.clines.api.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.caelum.clines.shared.domain.Users;

public interface UsersRepository extends Repository<Users, Long> {

	Optional<Users> findByEmail(String email);
	Optional<Users> findById(Long id);
	
	List<Users> findAll();

	void save(Users users);
	void deleteById(Long id);
}
