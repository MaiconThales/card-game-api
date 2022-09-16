package com.card.game.service;

import org.springframework.http.ResponseEntity;

import com.card.game.dto.request.LogOutRequestDTO;
import com.card.game.dto.request.LoginRequestDTO;
import com.card.game.dto.request.SignupRequestDTO;
import com.card.game.dto.request.TokenRefreshRequestDTO;
import com.card.game.dto.response.JwtResponseDTO;
import com.card.game.dto.response.MessageResponseDTO;
import com.card.game.dto.response.TokenRefreshResponseDTO;

public interface LoginService {

	JwtResponseDTO authenticateUser(LoginRequestDTO loginRequest);

	ResponseEntity<MessageResponseDTO> registerUser(SignupRequestDTO signUpRequest);

	ResponseEntity<TokenRefreshResponseDTO> refreshtoken(TokenRefreshRequestDTO request);

	ResponseEntity<MessageResponseDTO> logoutUser(LogOutRequestDTO logOutRequest);

	ResponseEntity<Boolean> isUserLogger();

}