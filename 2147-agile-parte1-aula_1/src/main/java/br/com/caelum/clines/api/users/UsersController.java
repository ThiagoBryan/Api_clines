package br.com.caelum.clines.api.users;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UsersController {

	private final UsersService usersService;

	@PostMapping
	public ResponseEntity<String> save(@RequestBody UsersForm usersForm) {
		return ResponseEntity.ok(usersService.createUsers(usersForm));
	}

	@GetMapping
	List<UsersView> list() {
		return usersService.ListAllUsers();
	}

	@GetMapping("/{id}")
	 UsersView user(@PathVariable Long id) {
		return usersService.showUsersById(id);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody UsersForm usersForm){
		return ResponseEntity.ok(usersService.update(id, usersForm));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		usersService.delete(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
