package com.card.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.card.game.model.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {

}
