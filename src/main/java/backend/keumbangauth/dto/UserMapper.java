package backend.keumbangauth.dto;

import backend.keumbangauth.grpc.token.TokenProto.UserResponseProto;

public class UserMapper {
	public static UserResponseProto toProto(UsersResponseDto user) {
		return UserResponseProto.newBuilder()
				.setId(user.getId())
				.setUsername(user.getUsername())
				.setRole(user.getRole())
				.build();
	}
}
