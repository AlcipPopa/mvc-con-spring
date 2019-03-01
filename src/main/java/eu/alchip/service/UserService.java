package eu.alchip.service;

import eu.alchip.exceptions.NoUserFoundException;
import eu.alchip.exceptions.UserAlreadyRegisteredException;
import eu.alchip.model.db.AdminUser;
import eu.alchip.model.db.AppUser;
import eu.alchip.model.dto.AppUserDTO;
import eu.alchip.repositories.UserRepository;
import eu.alchip.session.AppUserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private AppUserI userI;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void registerUser(AppUserDTO user) {
    	AppUser newUser = new AdminUser(user.getUsername(), user.getAge(), user.getJob(), user.getName(),
    			user.getSurname(), passwordEncoder.encode(user.getPassword()), null, true);
		if (userRepository.findById(newUser.getUsername()).isPresent()){
			throw new UserAlreadyRegisteredException("Utente gia registrato!");
		} else if (userRepository.save(newUser) != null){
			userI.setUsername(user.getUsername());
		}
    }
    
    public AppUser getUser(String username) {
    	Optional<AppUser> optional = userRepository.findById(username);
    	AppUser user = null;
    	
    	if (optional.isPresent()) {
    		user = optional.get();
    	}
    	
    	return user;
    }

    public boolean isAuthenticated(AppUserDTO user){
    	Optional<AppUser> queryResult = userRepository.findById(user.getUsername());
    	AppUser userFound = null;

    	if (queryResult.isPresent()){
			userFound = queryResult.get();
		} else {
    		throw new NoUserFoundException();
		}

    	return passwordEncoder.matches(user.getPassword(), userFound.getPassword());
	}
}
