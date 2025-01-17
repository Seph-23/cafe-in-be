package com.cafein.backend.api.login.dto;

import java.util.Date;

import com.cafein.backend.global.jwt.dto.JwtTokenDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

public class OAuthLoginDTO {

	@Data @Builder
	public static class Request {
		private String memberType;
	}

	@Data @Builder
	public static class Response {
		private String grantType;
		private String accessToken;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private Date accessTokenExpireTime;
		private String refreshToken;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private Date refreshTokenExpireTime;

		public static Response of(JwtTokenDTO jwtTokenDTO) {
			return Response.builder()
				.grantType(jwtTokenDTO.getGrantType())
				.accessToken(jwtTokenDTO.getAccessToken())
				.accessTokenExpireTime(jwtTokenDTO.getAccessTokenExpireTime())
				.refreshToken(jwtTokenDTO.getRefreshToken())
				.refreshTokenExpireTime(jwtTokenDTO.getRefreshTokenExpireTime())
				.build();
		}
	}
}
