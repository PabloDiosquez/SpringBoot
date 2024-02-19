package com.ltp.workbook.controller;

import com.ltp.workbook.Show;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class WorkbookController {

    
    @GetMapping(path="/")
    public String getShows(Model model){
        model.addAttribute("show1", new Show("Breaking Bad", "Ozymandias", 10.0));
        model.addAttribute("show2", new Show("Attack On Titan", "Hero", 9.9));
        model.addAttribute("show3", new Show("Attack On Titan", "Perfect Game", 9.9));
        model.addAttribute("show4", new Show("Star Wars: The Clone Wars", "Victory and Death", 9.9));
        model.addAttribute("show5", new Show("Mr. Robot", "407 Proxy Authentication Required", 9.9));
        return "shows";
    }

    /**
    @GetMapping(path="/")
    public ModelAndView getShows(){
        Map<String, Show> model = new HashMap<String, Show>();
        model.put("show1", new Show("Breaking Bad", "Ozymandias", 10.0));
        model.put("show2", new Show("Attack on Titan", "Hero", 9.9));
        model.put("show3", new Show("Attack on Titan", "Perfect Game", 9.9));
        model.put("show4", new Show("Star Wars: The Clone Wars", "Victory and Death", 	9.9));
        model.put("show5", new Show("Mr. Robot", "407 Proxy Authentication Required", 9.9));

        return new ModelAndView("shows", model);
    }
    **/
}
