package com.card.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.card.game.dto.DeckDTO;
import com.card.game.dto.response.MessageResponseDTO;
import com.card.game.service.DeckService;

@RestController
@RequestMapping("/deck")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DeckController {
	
	private final DeckService deckService;

	@Autowired
	public DeckController(DeckService deckService) {
		this.deckService = deckService;
	}
	
	@GetMapping("/list-all-deck")
	public ResponseEntity<List<DeckDTO>> getAllDecks() {
		return this.deckService.getAllDecks();
	}
	
	@GetMapping("/get-id-deck")
	public ResponseEntity<DeckDTO> getDeckById(@RequestParam long idDeck) {
		return this.deckService.getDeckById(idDeck);
	}
	
	@PostMapping("/save-deck")
	public ResponseEntity<MessageResponseDTO> saveDeck(@RequestBody DeckDTO deck) {
		return this.deckService.saveDeck(deck);
	}
	
	@DeleteMapping("/delete-deck")
	public ResponseEntity<MessageResponseDTO> delteDeck(@RequestParam long idDeck) {
		return this.deckService.deleteDeck(idDeck);
	}
}