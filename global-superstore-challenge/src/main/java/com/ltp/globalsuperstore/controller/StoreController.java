package com.ltp.globalsuperstore.controller;

import javax.validation.Valid;

import com.ltp.globalsuperstore.model.Item;
import com.ltp.globalsuperstore.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {

    private StoreService storeService = new StoreService();
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = storeService.getIndexFromId(id);
        model.addAttribute("item", storeService.getItem(index));
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {
        if (item.getPrice() < item.getDiscount()) {
            result.rejectValue("price", "", "Price cannot be less than discount");
        }
        if (result.hasErrors()) return "form";
        int index = storeService.getIndexFromId(item.getId());
        String status = storeService.updateItem(index, item);
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", storeService.getItems());
        return "inventory";
    }

}
