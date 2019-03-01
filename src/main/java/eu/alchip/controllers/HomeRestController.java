package eu.alchip.controllers;

import eu.alchip.model.dto.AppUserDTO;
import eu.alchip.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class HomeRestController {
    Logger logger = LoggerFactory.getLogger(HomeRestController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/pippo", produces = {"application/json"})
    public Map<String, AppUserDTO> getPippo(@ModelAttribute("utente") AppUserDTO userDTO){
        Map<String, List<String>> mappa = new HashMap<>();
        List<String> lista = new ArrayList<>();

        lista.add("Primo");
        lista.add("Secondo");
        lista.add("Terzo");

        mappa.put("ciao", lista);

        Map<String, AppUserDTO> mappa2 = new HashMap<>();
        mappa2.put("utente", userDTO);

        return mappa2;
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute("utente") AppUserDTO userDTO){
        String methodName = "login";
        logger.debug(userDTO.toString());


        if (userService.isAuthenticated(userDTO)){
            return "loginSuccess";
        } else {
            return "error";
        }
    }
}
