package com.card.game.dto;

public class CardDTO {
	
	private long id;
	private String nameCard;
	private int damage;
	private int life;
	
	public CardDTO() {
	}
	public CardDTO(long id, String nameCard, int damage, int life) {
		this.id = id;
		this.nameCard = nameCard;
		this.damage = damage;
		this.life = life;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
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