package br.com.caelum.clines.api.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.caelum.clines.shared.domain.Users;
import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;

class UsersServiceTest {

	private UsersRepository usersRepository;
	private UsersFormMapper usersFormMapper;
	private UsersViewMapper usersViewMapper;
	private UsersService usersService;

	@BeforeEach
	public void setup() {
		usersRepository = mock(UsersRepository.class);
		usersFormMapper = mock(UsersFormMapper.class);
		usersViewMapper = mock(UsersViewMapper.class);
		usersService = new UsersService(usersRepository, usersFormMapper, usersViewMapper);
	}

	@Test
	void createUsers__should_throw_ResourceAlreadyExistsException() {
		UsersForm form = new UsersForm();
		form.setEmail("teste@teste.com");

		Users user = new Users("Thiago", "teste@teste.com", "123", "teste");

		when(usersRepository.findByEmail(form.getEmail())).thenReturn(Optional.of(user));

		assertThrows(ResourceAlreadyExistsException.class, () -> usersService.createUsers(form));
	}

	@Test
	void createUsers__should_return_success_message() {
		UsersForm form = new UsersForm();
		form.setEmail("teste@teste.com");
		Users user = new Users(1L,"Thiago", "teste@teste.com", "123", "teste");
		
		when(usersRepository.findByEmail(form.getEmail())).thenReturn(Optional.empty());
		
	//	given(usersRepository.save(any())).willReturn(user);
		then(usersRepository).should().save(user);

		assertEquals("User created with Id: "+ user.getId(), usersService.createUsers(form));
		
	}

}
