package com.example.javagram;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping(path="/")
    public String getForm(Model model){
        return "sign-up";
    }

    @GetMapping(path="/result")
    public String getResult(){
        return "result";
    }
}
