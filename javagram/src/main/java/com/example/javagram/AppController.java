package com.example.javagram;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @GetMapping(path="/")
    public String getForm(Model model){
        model.addAttribute("user", new User());
        return "sign.up";
    }

    @GetMapping(path="/result")
    public String getResult(){
        return "result";
    }

    @PostMapping(path="/submitItem")
    public String handleSubmit(@Valid User user, BindingResult result){
        if(result.hasErrors()) return "sing.up";
        return "redirect:/result";
    }
}
