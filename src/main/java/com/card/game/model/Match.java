package com.card.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "match_player")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name = "player1", referencedColumnName = "id")
	private User player1;
	@OneToOne
	@JoinColumn(name = "player2", referencedColumnName = "id")
	private User player2;
	
	public Match() {
	}
	public Match(User player1, User player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	public Match(long id, User player1, User player2) {
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