package com.ltp.workbook.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path="shows")
    public String getShows(){
        return "shows";
    }
}
