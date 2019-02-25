package mx.com.kodikas.reviews.auth.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/users/sign_in", "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		
		if(username == null) {
			username = "";
		}
		
		if(password == null) {
			password = "";
		}
		
		username = username.trim();
		
		//Obtener credenciales
		UsernamePasswordAuthenticationToken authToken = 
				new UsernamePasswordAuthenticationToken(username, password);
		
		//se realiza la autenticación con JPA
		return authenticationManager.authenticate(authToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
		String token = Jwts.builder()
				.setSubject(authResult.getName())
				.signWith(SignatureAlgorithm.HS512, "Mi.Clave.Secreta.123456".getBytes())
				.compact();
		
		response.addHeader("Authorization", "Bearer "+token);
		
		Map<String, Object> body = new HashMap<>();
		body.put("token", token);
		body.put("user", (User)authResult.getPrincipal());
		body.put("mensaje", "Has iniciado con éxito");
		
		//Convirtiendo el token a JSON y enviándolo al cliente
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(200);
		response.setContentType("application/json");
	}
	
	

}
