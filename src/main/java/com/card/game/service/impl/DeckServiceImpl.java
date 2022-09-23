package com.card.game.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.card.game.dto.DeckDTO;
import com.card.game.dto.response.MessageResponseDTO;
import com.card.game.model.Deck;
import com.card.game.repository.DeckRepository;
import com.card.game.service.DeckService;

@Service
public class DeckServiceImpl implements DeckService {
	
	private static final String ERROR_SERVER = "ERROR_SERVER";
	private static final String SUCCESS_SERVER = "SUCCESS_SERVER";
	
	private final ModelMapper modelMapper;
	private final DeckRepository deckRepository;
	
	@Autowired
	public DeckServiceImpl(DeckRepository deckRepository, ModelMapper modelMapper) {
		this.deckRepository = deckRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<List<DeckDTO>> getAllDecks() {
		List<DeckDTO> listResult = null;
		try {
			List<Deck> listDeck = this.deckRepository.findAll();
			listResult = listDeck.stream().map(m -> modelMapper.map(m, DeckDTO.class)).toList();
			return new ResponseEntity<>(listResult, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listResult, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<DeckDTO> getDeckById(long idDeck) {
		DeckDTO resultDeck = null;
		try {
			Deck deck = this.deckRepository.getById(idDeck);
			resultDeck = modelMapper.map(deck, DeckDTO.class);
			return new ResponseEntity<>(resultDeck, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(resultDeck, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<MessageResponseDTO> saveDeck(DeckDTO deck) {
		try {
			Deck objSave = modelMapper.map(deck, Deck.class);
			this.deckRepository.save(objSave);
			return new ResponseEntity<>(new MessageResponseDTO(SUCCESS_SERVER), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new MessageResponseDTO(ERROR_SERVER), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<MessageResponseDTO> deleteDeck(long idDeck) {
		try {
			this.deckRepository.deleteById(idDeck);
			return new ResponseEntity<>(new MessageResponseDTO(SUCCESS_SERVER), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new MessageResponseDTO(ERROR_SERVER), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
