package com.ltp.globalsuperstore;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class StoreController {
    private final List<Item> items = new ArrayList<>();

    @GetMapping(path="/")
    public String getForm(Model model, @RequestParam(required = false) String id){
        model.addAttribute("categories", Constants.CATEGORIES);
        int index = getIndexFromId(id);
        model.addAttribute("item", index == Constants.NOT_FOUND ? new Item() : items.get(index));
        return "form";
    }

    @GetMapping(path="/inventory")
    public String getInventory(Model model){
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping(path="/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes){
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if(index == Constants.NOT_FOUND){
            items.add(item);
        } else if (within5Days(item.getDate(), items.get(index).getDate())){
            items.set(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/inventory";
    }

    private int getIndexFromId(String id){
        for (int index = 0; index < items.size(); index++) {
            if(items.get(index).getId().equals(id)){
                return index;
            }
        }
        return Constants.NOT_FOUND;
    }
    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}
