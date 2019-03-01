package eu.alchip.controllers;

import eu.alchip.model.dto.AppUserDTO;
import eu.alchip.service.UserService;
import eu.alchip.session.AppUserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    @Qualifier("appUserDTO")
    private AppUserI userI;

	@Autowired
	private UserService userService;
	
    @GetMapping({"","logout"})
    public String index(){
        return "index";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }

    @PostMapping(value = "register")
    public String registra(@ModelAttribute("utente") AppUserDTO userDTO, Model model)  {
        String methodName = "register";
        logger.debug(userDTO.toString());

        userService.registerUser(userDTO);
        model.addAttribute("utente", userI);
        return "registered";
    }


    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("utente", userI);
        return "login";
    }
}
