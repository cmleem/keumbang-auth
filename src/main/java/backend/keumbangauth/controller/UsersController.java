package backend.keumbangauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.keumbangauth.dto.SignupRequestDto;
import backend.keumbangauth.dto.TokenResponseDto;
import backend.keumbangauth.dto.UsersResponseDto;
import backend.keumbangauth.entity.Users;
import backend.keumbangauth.service.UsersService;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsersController {

	private final UsersService usersService;
	
	@PostMapping("/signup")
	@PermitAll
	public ResponseEntity<?> signup(
			@RequestBody SignupRequestDto signupRequestDto
			){
		Users user = usersService.create(signupRequestDto.getUsername(),
				signupRequestDto.getPassword());
		
		return ResponseEntity.ok(UsersResponseDto.toDto(user));
	}
	
	@GetMapping("/get")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> get(@AuthenticationPrincipal Users user){
		return ResponseEntity.ok(TokenResponseDto.toDto(user));
	}
	
}
