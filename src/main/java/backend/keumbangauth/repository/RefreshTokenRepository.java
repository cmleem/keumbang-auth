package backend.keumbangauth.repository;

import org.springframework.data.repository.CrudRepository;

import backend.keumbangauth.entity.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String>{

}