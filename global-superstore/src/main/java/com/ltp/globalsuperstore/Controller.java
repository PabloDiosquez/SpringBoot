package com.ltp.globalsuperstore;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path="/")
    public String getForm(Model model){
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @GetMapping(path="/inventory")
    public String getInventory(){
        return "inventory";
    }
}
