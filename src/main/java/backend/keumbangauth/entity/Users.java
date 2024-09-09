package backend.keumbangauth.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users implements UserDetails {
	private static final long serialVersionUID = 8231767905030414611L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(nullable = false, unique = true)
	String username;
	
	@Column(nullable = false)
	String password;
	
	@Builder.Default
	@Column(nullable = false)
	String role = "ROLE_BASIC";
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new GrantedAuthority() {

			private static final long serialVersionUID = 7861920201604242529L;

			@Override
			public String getAuthority() {
				return role;
			}
		});
		
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return UserDetails.super.isAccountNonExpired();
	}
	@Override
	public boolean isAccountNonLocked() {
		return UserDetails.super.isAccountNonLocked();
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return UserDetails.super.isCredentialsNonExpired();
	}
	@Override
	public boolean isEnabled() {
		return UserDetails.super.isEnabled();
	}
}
