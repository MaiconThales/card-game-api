package com.card.game.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.game.enums.ERole;
import com.card.game.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);

}