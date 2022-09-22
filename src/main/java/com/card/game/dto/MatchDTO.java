package com.card.game.dto;

import com.card.game.model.User;

public class MatchDTO {

	private long id;
	private User player1;
	private User player2;
	
	public MatchDTO() {
	}
	public MatchDTO(long id, User player1, User player2) {
		this.id = id;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getPlayer1() {
		return player1;
	}
	public void setPlayer1(User player1) {
		this.player1 = player1;
	}
	public User getPlayer2() {
		return player2;
	}
	public void setPlayer2(User player2) {
		this.player2 = player2;
	}
	
}