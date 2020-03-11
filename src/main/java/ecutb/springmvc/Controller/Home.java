package ecutb.springmvc.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    List<String> inputList = new ArrayList<>();

    //-------------------------- Exercise 1 --------------------------

    @GetMapping("/index")
    public String index(){
        return null;
    }

    //-------------------------- Exercise 2 --------------------------

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    //  receive inputs from user and add it ti inputList.
    @PostMapping("/contact")
    public String contact(@RequestParam(value = "input")String input){
        if(!input.isEmpty()){
            inputList.add(input);
        }
        return "redirect:contact";
    }

    //  Show inputList on contact-view
    @GetMapping("/contact-list") //  url to show the list of inputList
    public String contactList(Model model){
        model.addAttribute("inputs", inputList);
        return "contact-view";
    }

    //-------------------------- Exercise 3 --------------------------

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("image", "img/springBoot.jpeg");
        return "about";
    }

    //-------------------------- Exercise 4 --------------------------



}
