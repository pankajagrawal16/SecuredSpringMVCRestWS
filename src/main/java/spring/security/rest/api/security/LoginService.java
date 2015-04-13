package spring.security.rest.api.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.security.rest.api.entity.CurrentUser;

/**
 * The service is used to authenticate the login details as provided in the
 * request parameter. This should be used to fetch the user details on the basis
 * of userName passed in the request from DB. One can update the CurrentUser
 * class to hold additional attributes about the user details
 * 
 * @author OptimumAlgorithms
 */

@Service
@Transactional(readOnly = true)
public class LoginService implements UserDetailsService {

	Logger logger = Logger.getLogger(LoginService.class);

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		// Fetch the details of the user specific to userName from the DataBase
		// and create the CurrentUser instance accordingly

		String role = "";
		// Create a new user and return it to the framework
		return new CurrentUser(userName, "password", getAuthorities(1),
				"OptimumAlgorithms", "admin@gmail.com", "ROLE_ADMIN");
	}

	/**
	 * The method should be updated to return the authorities based on the role
	 * supplied
	 * 
	 * @param role
	 * @return
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/**
	 * HardCoded role. Update accordingly
	 * 
	 * @param role
	 * @return
	 */
	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;

			{
				add("ROLE_ADMIN");
			}
		};

		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
