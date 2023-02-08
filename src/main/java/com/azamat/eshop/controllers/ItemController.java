package com.azamat.eshop.controllers;

import com.azamat.eshop.models.Item;
import com.azamat.eshop.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/item/add")
    public String add(){
        return "addItem";
    }

    @PostMapping("/item/add")
    public String store(
                @RequestParam String title,
                @RequestParam String image,
                @RequestParam String price,
                @RequestParam String info
                    ){
        Item item = new Item(title, image, info, Short.parseShort (price));
        itemRepository.save(item);
        return "redirect:/";
    }

    @GetMapping("/item/{id}")
    public String showItem(@PathVariable(value = "id") long id, Model model){
        Item item = itemRepository.findById(id).orElse(new Item());
        model.addAttribute("item", item);
        return "showItem";
    }

    @GetMapping("/item/{id}/update")
    public String update(@PathVariable(value =  "id") long id, Model model){
        Item item = itemRepository.findById(id).orElse(new Item());
        model.addAttribute("item", item);
        return "item-update";
    }
}
