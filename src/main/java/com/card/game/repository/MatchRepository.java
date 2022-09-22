package com.card.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.card.game.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

	@Query(value = "SELECT * FROM match_player WHERE player1 = :idUser", nativeQuery = true)
	Match getPlayer1(@Param("idUser") Long idUser);
	
	@Query(value = "SELECT * FROM match_player WHERE player2 = :idUser", nativeQuery = true)
	Match getPlayer2(@Param("idUser") Long idUser);
	
	@Query(value = "SELECT * FROM match_player WHERE player2 IS NULL", nativeQuery = true)
	Match getMatchAvailable();
	
}