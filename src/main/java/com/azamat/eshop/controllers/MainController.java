package com.azamat.eshop.controllers;

import com.azamat.eshop.models.Item;
import com.azamat.eshop.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String index(Model model){
        Iterable<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping("/aboutus")
    public String aboutUs(@RequestParam(name = "userName", required = false, defaultValue = "world") String userName,  Model model){
        model.addAttribute("name", userName);

        return "aboutus";
    }

}
