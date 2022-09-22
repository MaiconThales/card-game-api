package com.card.game.service;

import org.springframework.http.ResponseEntity;

import com.card.game.dto.MatchDTO;
import com.card.game.dto.UserDTO;

public interface MatchService {
	
	ResponseEntity<MatchDTO> searchMatch(UserDTO user);

}