package backend.keumbangauth.dto;

import backend.keumbangauth.grpc.token.TokenProto.TokenResponseProto;
import backend.keumbangauth.grpc.token.TokenProto.UserResponseProto;

public class TokenMapper {
	public static TokenResponseProto toProto(TokenResponseDto dto) {
		UserResponseProto userProto = UserMapper.toProto(dto.getUser());
		return TokenResponseProto.newBuilder()
				.setIsValid(dto.getIsValid())
				.setUser(userProto)
				.build();
	}
}
