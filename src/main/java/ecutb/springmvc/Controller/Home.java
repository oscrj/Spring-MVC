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

    @GetMapping("index")
    public String index(){
        return null;
    }

    @GetMapping("contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("contact")
    public String contact(@RequestParam()String input){
        if(!input.isEmpty()){
            inputList.add(input);
        }
        return "redirect:contact-list";
    }

    @GetMapping("contact-list")
    public String contactList(Model model){
        model.addAttribute("inputs", inputList);
        return "contact";
    }

    @GetMapping("about")
    public String about(Model model){
        model.addAttribute("image", "img/springBoot.jpeg");
        return "about";
    }
}
