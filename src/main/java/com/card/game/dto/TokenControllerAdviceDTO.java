package com.card.game.dto;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.card.game.exception.TokenRefreshException;

@RestControllerAdvice
public class TokenControllerAdviceDTO {
	
	@ExceptionHandler(value = TokenRefreshException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorMessageDTO handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {
		return new ErrorMessageDTO(HttpStatus.FORBIDDEN.value(), new Date(), ex.getMessage(),
				request.getDescription(false));
	}

}
