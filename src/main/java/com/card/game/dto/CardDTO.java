package com.card.game.dto;

public class CardDTO {
	
	private Long id;
	private String nameCard;
	private int damage;
	private int life;
	
	public CardDTO() {
	}
	public CardDTO(Long id, String nameCard, int damage, int life) {
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