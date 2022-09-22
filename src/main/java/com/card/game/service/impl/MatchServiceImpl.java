package com.card.game.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.card.game.dto.MatchDTO;
import com.card.game.dto.UserDTO;
import com.card.game.model.Match;
import com.card.game.model.User;
import com.card.game.repository.MatchRepository;
import com.card.game.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {
	
	private final ModelMapper modelMapper;
	private final MatchRepository matchRepository;
	
	@Autowired
	public MatchServiceImpl(MatchRepository matchRepository, ModelMapper modelMapper) {
		this.matchRepository = matchRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<MatchDTO> searchMatch(UserDTO user) {
		User player = null;
		Match m = null;
		MatchDTO result = null;
		
		player = modelMapper.map(user, User.class);
		m = this.findMatchExists(player);
		if(m == null) {//No exists match
			m = this.createOrUpdateMatch(player);
		}
		result = modelMapper.map(m, MatchDTO.class);
		
		if(result.getPlayer1() != null && result.getPlayer2() != null) {
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	private Match findMatchExists(User player) {
		Match result = null;
		result = this.matchRepository.getPlayer1(player.getId());
		if(result == null) {
			result = this.matchRepository.getPlayer2(player.getId());
		}
		return result;
	}

	private Match createOrUpdateMatch(User player) {
		Match m = this.matchRepository.getMatchAvailable();
		if(m == null) {//Sem disponivel
			m = new Match(player, null);
			m = this.matchRepository.save(m);
		} else {//Disponivel
			m.setPlayer2(player);
			m = this.matchRepository.save(m);
		}
		return m;
	}
	
}