package com.cg.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cg.dto.LoginData;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

@Service
public class JwtUtil {

	private String SECRET_KEY = "secret";
	private final String TOKEN_HEADER = "Authorization";
	private final String TOKEN_PREFIX = "Bearer ";
	private static final long VALIDITY = 3 * 60 * 60 * 1000; // 3 hours

	private final JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET_KEY);

	public String createToken(LoginData user) {
		Claims claims = Jwts.claims().setSubject(user.getUsername());

		Date createTime = new Date();
		Date validityTime = new Date(createTime.getTime() + VALIDITY);
		String token = Jwts.builder()
						.setClaims(claims)
						.setExpiration(validityTime)
						.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
						.compact();
		return token;
	}

	public Claims getClaims(String token) {
		if (token != null)
			return jwtParser.parseClaimsJws(token).getBody();
		return null;
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getName(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getClaims(token).getExpiration();
		return expiration.before(new Date());
	}

	public String getName(String token) {
		return getClaims(token).getSubject();
	}

}