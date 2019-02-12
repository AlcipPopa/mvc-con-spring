package eu.alchip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import eu.alchip.model.dto.AppUserDTO;
import eu.alchip.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
    @GetMapping("")
    public String index(){
        return "index";
    }


    @PostMapping("/register")
    public String registra(@RequestBody AppUserDTO user) {
        userService.registerUser(user);
        return "success";
    }

    @GetMapping("/indice")
    public String indice(){
        return "indice";
    }
}
