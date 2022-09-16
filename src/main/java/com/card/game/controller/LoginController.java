package com.card.game.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.game.dto.request.LogOutRequestDTO;
import com.card.game.dto.request.LoginRequestDTO;
import com.card.game.dto.request.SignupRequestDTO;
import com.card.game.dto.request.TokenRefreshRequestDTO;
import com.card.game.dto.response.JwtResponseDTO;
import com.card.game.dto.response.MessageResponseDTO;
import com.card.game.dto.response.TokenRefreshResponseDTO;
import com.card.game.service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {
	
	private final LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@PostMapping("/auth/signin")
	public ResponseEntity<JwtResponseDTO> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
		return ResponseEntity.ok(this.loginService.authenticateUser(loginRequest));
	}

	@PostMapping("/auth/signup")
	public ResponseEntity<MessageResponseDTO> registerUser(@Valid @RequestBody SignupRequestDTO signUpRequest) {
		return this.loginService.registerUser(signUpRequest);
	}

	@PostMapping("/auth/refreshtoken")
	public ResponseEntity<TokenRefreshResponseDTO> refreshtoken(@Valid @RequestBody TokenRefreshRequestDTO request) {
		return this.loginService.refreshtoken(request);
	}

	@PostMapping("/auth/logout")
	public ResponseEntity<MessageResponseDTO> logoutUser(@Valid @RequestBody LogOutRequestDTO logOutRequest) {
		return this.loginService.logoutUser(logOutRequest);
	}

	@GetMapping("/auth/isLogged")
	public ResponseEntity<Boolean> isUserLogger() {
		return this.loginService.isUserLogger();
	}

}