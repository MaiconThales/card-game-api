package com.card.game.dto;

import java.util.List;

public class DeckDTO {
	
	private long id;
	private String nameDeck;
	private List<CardDTO> cards;
	
	public DeckDTO() {
	}
	public DeckDTO(long id, String nameDeck, List<CardDTO> cards) {
		this.id = id;
		this.nameDeck = nameDeck;
		this.cards = cards;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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