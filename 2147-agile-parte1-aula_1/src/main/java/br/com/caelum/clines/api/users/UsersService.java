package br.com.caelum.clines.api.users;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.clines.shared.domain.Users;
import br.com.caelum.clines.shared.exceptions.ResourceAlreadyExistsException;
import br.com.caelum.clines.shared.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersService {

	@Autowired
	private final UsersRepository usersRepository;
	
	private final UsersFormMapper usersFormMapper;
	private final UsersViewMapper usersViewMapper;

	public String createUsers(UsersForm form) {
		usersRepository.findByEmail(form.getEmail()).ifPresent(user -> {
			throw new ResourceAlreadyExistsException("User already exists");
		});

		Users saveUsers = usersFormMapper.map(form);
		usersRepository.save(saveUsers);
//		UsersDTo dto = usersDtoMapper.map(saveUsers);
//		return dto;
		return "User created with Id: " + saveUsers.getId();
	}
	
	public List<UsersView> ListAllUsers(){
		return usersRepository.findAll().stream().map(usersViewMapper::map).collect(toList());
		
	}
	
	public UsersView showUsersById(Long usersViewId) {
		Users users = usersRepository.findById(usersViewId).orElseThrow(() -> new ResourceNotFoundException("Cannot find User"));
		return usersViewMapper.map(users);
	}
	
	public String update(Long IdUser, UsersForm usersForm) {
		Optional<Users> users = usersRepository.findById(IdUser);
		Users updateUser = new Users();
		if(users.isPresent()) {
			updateUser = users.get();
			if(updateUser.getName() != null) {
				updateUser.setName(usersForm.getName());
			}
			if(updateUser.getEmail() != null) {
				updateUser.setEmail(usersForm.getEmail());
			}
			if(updateUser.getPassword() != null) {
				updateUser.setPassword(usersForm.getPassword());
			}
			if(updateUser.getInfoUsers() != null) {
				updateUser.setInfoUsers(usersForm.getInfoUsers());
			}
			usersRepository.save(updateUser);
		}
		return "The user with Id " + updateUser.getId() + " was updated";
		
	}
	
	public void delete(Long id) {
		Optional<Users> user = usersRepository.findById(id);
			if(user.isPresent()) {
				usersRepository.deleteById(id);
			}
	}

}
