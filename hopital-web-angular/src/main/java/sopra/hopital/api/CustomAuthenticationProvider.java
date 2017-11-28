package sopra.hopital.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import sopra.hopital.model.Role;
import sopra.hopital.model.Utilisateur;
import sopra.hopital.repository.UtilisateurRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String login = authentication.getName();
		String password = authentication.getCredentials().toString();

		Utilisateur pers = utilisateurRepo.auth(login, password);

		// si pers est different de null
		if (pers != null) {

			// si l'utilisateur est un admin
			if (pers.getRole().equals(Role.ADMIN)) {
				List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				return new UsernamePasswordAuthenticationToken(login, password, grantedAuths);
			}

			// Si l'utilisateur est une secretaire
			else if (pers.getRole().equals(Role.SECRETAIRE)) {
				List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_SECRETAIRE"));
				return new UsernamePasswordAuthenticationToken(login, password, grantedAuths);
			}

			// si l'utilisateur est un medecin
			else if (pers.getRole().equals(Role.MEDECIN)) {
				List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_MEDECIN"));
				return new UsernamePasswordAuthenticationToken(login, password, grantedAuths);

			}
		}

		return null;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}