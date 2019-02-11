package eu.alchip.service;

import java.util.Optional;

import eu.alchip.model.db.NormalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import eu.alchip.model.db.AppUser;
import eu.alchip.model.dto.AppUserDTO;
import eu.alchip.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void registerUser(AppUserDTO user) {
    	AppUser newUser = new AppUser (user.getEmail(), user.getAge(), user.getJob(), user.getName(),
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
}
