package mx.com.kodikas.reviews.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import mx.com.kodikas.reviews.dao.IUserDao;
import mx.com.kodikas.reviews.entities.Role;
import mx.com.kodikas.reviews.entities.User;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{
	
	private final Log logger = LogFactory.getLog(JpaUserDetailsService.class);

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("El email obtenido es: "+username);
		
		User user = userDao.findByEmail(username);
		
		if (user == null) {
			logger.info("Error, no exise el usuario");
			throw new UsernameNotFoundException("Usuario no existe");
		}
		
		logger.info("El email obtenido es: "+username +" y si existe");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if (user.getRoles().isEmpty()) {
			logger.info("No hay roles asignados al usuario");
			throw new UsernameNotFoundException("El usuario no tiene roles asociados");
		}
		
		if (!user.getRoles().isEmpty()) {
			logger.info("El usuario tiene roles");
		}
		
		for(Role role : user.getRoles()) {
			logger.info("Rol: " + role.getAuthority());
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), true, 
				true, true, true, authorities);
	}
	
	

}
