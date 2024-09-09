package backend.keumbangauth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import backend.keumbangauth.repository.UsersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = usersRepository.findByUsername(username);
		if (user.isPresent())
			return user.get();
		
		return null;
	}

}
