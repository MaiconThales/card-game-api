package com.card.game.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.card.game.model.RefreshToken;

public interface RefreshTokenService {
	
	public Optional<RefreshToken> findByToken(String token);

	public RefreshToken createRefreshToken(Long userId);

	public RefreshToken verifyExpiration(RefreshToken token);

	@Transactional
	public int deleteByUserId(Long userId);

}