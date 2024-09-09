package backend.keumbangauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.keumbangauth.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);
	Boolean existsByUsername(String username);
}
