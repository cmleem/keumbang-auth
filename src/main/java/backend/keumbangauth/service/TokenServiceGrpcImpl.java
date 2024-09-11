package backend.keumbangauth.service;

import backend.keumbangauth.dto.TokenMapper;
import backend.keumbangauth.dto.TokenResponseDto;
import backend.keumbangauth.entity.Users;
import backend.keumbangauth.grpc.token.TokenProto.TokenRequestProto;
import backend.keumbangauth.grpc.token.TokenProto.TokenResponseProto;
import backend.keumbangauth.grpc.token.TokenServiceGrpc.TokenServiceImplBase;
import backend.keumbangauth.jwt.JWTUtil;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class TokenServiceGrpcImpl extends TokenServiceImplBase {
	private final JWTUtil jwtUtil;
	private final UsersService usersService;
	
	@Override
	public void getUser(TokenRequestProto request, StreamObserver<TokenResponseProto> responseObserver) {
		String token = request.getAccess();
		
		String username = jwtUtil.getUsername(token);
		Users user = usersService.get(username);
		TokenResponseDto response = TokenResponseDto.toDto(user);
		TokenResponseProto proto = TokenMapper.toProto(response);
		responseObserver.onNext(proto);
		responseObserver.onCompleted();
	}
}
