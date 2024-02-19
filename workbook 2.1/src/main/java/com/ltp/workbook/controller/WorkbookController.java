package com.ltp.workbook.controller;

import com.ltp.workbook.Show;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class WorkbookController {

    @GetMapping(path="/")
    public String getShows(Model model){
        Show show = new Show("Breaking Bad", "Ozymandias", 10.0);
        model.addAttribute("show", show);
        return "shows";
    }
}
