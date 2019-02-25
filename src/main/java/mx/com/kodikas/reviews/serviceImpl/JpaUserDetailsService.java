package mx.com.kodikas.reviews.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import mx.com.kodikas.reviews.dao.IUserDao;
import mx.com.kodikas.reviews.entities.Role;
import mx.com.kodikas.reviews.entities.User;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("Usuario no existe");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if (authorities.isEmpty()) {
			throw new UsernameNotFoundException("El usuario no tiene roles asociados");
		}
		
		for(Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), true, 
				true, true, true, authorities);
	}
	
	

}
