package backend.keumbangauth.dto;

import backend.keumbangauth.entity.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersResponseDto {
	Long id;
	String username;
	String role;
	
	public static UsersResponseDto toDto(Users entity) {
		return UsersResponseDto.builder()
				.id(entity.getId())
				.username(entity.getUsername())
				.role(entity.getRole())
				.build();
	}
}
