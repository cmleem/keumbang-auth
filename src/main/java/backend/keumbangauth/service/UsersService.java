package backend.keumbangauth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.keumbangauth.entity.Users;
import backend.keumbangauth.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
	private final UsersRepository usersRepository;
	private final PasswordEncoder passwordEncoder;
	public Users create(String username, String password) {
		Users user = Users.builder()
				.username(username)
				.password(passwordEncoder.encode(password))
				.build();
		
		return usersRepository.save(user);
	}
	
	public Users get(String username) {
		return usersRepository.findByUsername(username).orElseThrow();
	}
}
