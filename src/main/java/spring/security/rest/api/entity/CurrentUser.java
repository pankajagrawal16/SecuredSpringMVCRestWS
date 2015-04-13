package spring.security.rest.api.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * It contains the login user details with the use of spring user. Keep the
 * attribute names in this class in sync with editProfile.jsp
 * 
 * @author OptimumAlgorithms
 */
public class CurrentUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5926534690748386796L;

	private final String memberName;
	private final String emailAddress;
	private final String role;
	private String password;

	public CurrentUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities,
			String memberName, String emailAddress, String role) {

		super(username, password, authorities);

		this.memberName = memberName;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getRole() {
		return role;
	}

}
