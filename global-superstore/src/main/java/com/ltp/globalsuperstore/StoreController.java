package com.ltp.globalsuperstore;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {
    private List<Item> items = new ArrayList<>();

    @GetMapping(path="/")
    public String getForm(Model model){
        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("item", new Item());
        return "form";
    }

    @GetMapping(path="/inventory")
    public String getInventory(Model model){
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping(path="/submitItem")
    public String handleSubmit(Item item){
        items.add(item);
        return "redirect:/inventory";
    }
}
