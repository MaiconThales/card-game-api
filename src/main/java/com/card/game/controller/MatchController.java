package com.card.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.game.dto.MatchDTO;
import com.card.game.dto.UserDTO;
import com.card.game.service.MatchService;

@RestController
@RequestMapping("/match")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MatchController {

	private final MatchService matchService;

	@Autowired
	public MatchController(MatchService matchService) {
		this.matchService = matchService;
	}
	
	@PostMapping("/search-match")
	public ResponseEntity<MatchDTO> searchMatch(@RequestBody UserDTO user) {
		return this.matchService.searchMatch(user);
	}
	
}