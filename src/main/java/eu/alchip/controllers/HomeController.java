package eu.alchip.controllers;

import eu.alchip.model.dto.AppUserDTO;
import eu.alchip.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
    @GetMapping("")
    public String index(){
        return "index";
    }


    @PostMapping(value = "/register")
    public String registra(@ModelAttribute("utente") AppUserDTO userDTO)  {
        String methodName = "register";
        logger.debug(userDTO.toString());

        userService.registerUser(userDTO);
        return "registered";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("utente") AppUserDTO userDTO){
        String methodName = "login";
        logger.debug(userDTO.toString());

        if (userService.isAuthenticated(userDTO)){
            return "success";
        } else {
            return "error";
        }
    }



    @GetMapping("/indice")
    public String indice(){
        return "indice";
    }
}
