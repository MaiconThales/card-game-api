package com.card.game.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.card.game.dto.DeckDTO;
import com.card.game.dto.response.MessageResponseDTO;

public interface DeckService {
	
	ResponseEntity<List<DeckDTO>> getAllDecks();
	
	ResponseEntity<DeckDTO> getDeckById(long idDeck);
	
	ResponseEntity<MessageResponseDTO> saveDeck(DeckDTO deck);
	
	ResponseEntity<MessageResponseDTO> deleteDeck(long idDeck);

}
