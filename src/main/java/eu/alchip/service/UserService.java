package eu.alchip.service;

import eu.alchip.exceptions.NoUserFoundException;
import eu.alchip.model.db.AppUser;
import eu.alchip.model.dto.AppUserDTO;
import eu.alchip.repositories.UserRepository;
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
	private ShoppingCart shoppingCart;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void registerUser(AppUserDTO user) {
		shoppingCart.setEmail(user.getEmail());

    	AppUser newUser = new AppUser(user.getEmail(), user.getAge(), user.getJob(), user.getName(),
    			user.getSurname(), passwordEncoder.encode(user.getPassword()), null);
    	userRepository.save(newUser);
    }
    
    public AppUser getUser(String email) {
    	Optional<AppUser> optional = userRepository.findById(email);
    	AppUser user = null;
    	
    	if (optional.isPresent()) {
    		user = optional.get();
    	}
    	
    	return user;
    }

    public boolean isAuthenticated(AppUserDTO user){
    	Optional<AppUser> queryResult = userRepository.findById(user.getEmail());
    	AppUser userFound = null;

    	if (queryResult.isPresent()){
			userFound = queryResult.get();
		} else {
    		throw new NoUserFoundException();
		}

    	return passwordEncoder.matches(user.getPassword(), userFound.getPassword());
	}
}
