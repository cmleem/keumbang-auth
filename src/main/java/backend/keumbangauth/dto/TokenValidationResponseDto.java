package backend.keumbangauth.dto;

import backend.keumbangauth.entity.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenValidationResponseDto {
	Boolean isValid;
	UsersResponseDto user;
	
	public static TokenValidationResponseDto toDto(Users entity) {
		return TokenValidationResponseDto.builder()
				.isValid(true)
				.user(UsersResponseDto.toDto(entity))
				.build();
	}
}
