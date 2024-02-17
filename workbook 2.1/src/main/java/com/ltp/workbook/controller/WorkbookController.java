package com.ltp.workbook.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class WorkbookController {

    @GetMapping(path="/")
    public String getShows(){
        return "shows";
    }
}
