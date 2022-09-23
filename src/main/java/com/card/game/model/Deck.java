package com.card.game.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "deck")
public class Deck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nameDeck;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			  name = "deck_card", 
			  joinColumns = @JoinColumn(name = "id_card"), 
			  inverseJoinColumns = @JoinColumn(name = "id_deck"))
	private List<Card> cards;
	
	public Deck() {
	}
	public Deck(long id, String nameDeck, List<Card> cards) {
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
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}