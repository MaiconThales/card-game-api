package com.card.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nameCard;
	@Column
	private int damage;
	@Column
	private int life;
	
	public Card() {
	}
	public Card(Long id, String nameCard, int damage, int life) {
		this.id = id;
		this.nameCard = nameCard;
		this.damage = damage;
		this.life = life;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameCard() {
		return nameCard;
	}
	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}

}