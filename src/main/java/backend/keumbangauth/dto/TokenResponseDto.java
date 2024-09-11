package backend.keumbangauth.dto;

import backend.keumbangauth.entity.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponseDto {
	Boolean isValid;
	UsersResponseDto user;
	
	public static TokenResponseDto toDto(Users entity) {
		return TokenResponseDto.builder()
				.isValid(true)
				.user(UsersResponseDto.toDto(entity))
				.build();
	}
}
