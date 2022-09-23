package com.card.game.dto;

import java.util.List;

public class DeckDTO {
	
	private Long id;
	private String nameDeck;
	private List<CardDTO> cards;
	
	public DeckDTO() {
	}
	public DeckDTO(Long id, String nameDeck, List<CardDTO> cards) {
		this.id = id;
		this.nameDeck = nameDeck;
		this.cards = cards;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameDeck() {
		return nameDeck;
	}
	public void setNameDeck(String nameDeck) {
		this.nameDeck = nameDeck;
	}
	public List<CardDTO> getCards() {
		return cards;
	}
	public void setCards(List<CardDTO> cards) {
		this.cards = cards;
	}

}