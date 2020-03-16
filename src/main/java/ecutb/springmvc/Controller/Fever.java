package ecutb.springmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fever {

    @GetMapping("/temp")
    public String bodyTemperature(Model model){
        model.addAttribute("image", "img/Thermometer.png");
        return "bodytemp";
    }

    @PostMapping("/temp")
    public String temp(@RequestParam(name = "bodyTemp", defaultValue = "0.0") Double bodyTemp, Model model){

        if(bodyTemp <= 28){
            model.addAttribute("image", "img/Hypothermia.png");
            model.addAttribute("information", "Your body temperature are " + bodyTemp +"!");
            model.addAttribute("info", "You are probably unconscious and cant read this...");
            model.addAttribute("info2","Most likely you will die!");
            model.addAttribute("info3","Bye..");
            return "hypothermia";
        }

        if(bodyTemp <= 35 && bodyTemp > 28){
            model.addAttribute("image", "img/Hypothermia.png");
            model.addAttribute("information", "Your body temperature are " + bodyTemp +"!");
            model.addAttribute("info", "Remove wet clothes");
            model.addAttribute("info2","Put on a blanket and make sure your body stays warm and dry");
            model.addAttribute("info3","DONT Enjoy a bowl of Ice cream! Drink something HOT instead");
            return "hypothermia";
        }

        if(bodyTemp > 35 && bodyTemp < 37.5){
            model.addAttribute("image","img/Normal.png");
            model.addAttribute("information","Your body temperature are " + bodyTemp +"!");
            model.addAttribute("info","Its a normal body temperature, go on and live our life as a normal day");
            return "normal";
        }

        if(bodyTemp >= 37.5 && bodyTemp <= 42){
            model.addAttribute("image","img/FeverBrain.png");
            model.addAttribute("information","Your body temperature are " + bodyTemp +"!");
            model.addAttribute("info","Go to bed and sleep it of");
            model.addAttribute("info2","Take an aspirin to lower the fever");
            model.addAttribute("info3","If you are a male, dont worry you are not going to die!");
            model.addAttribute("info4","Enjoy a bowl of Ice cream");
            return "fever";
        }

        if(bodyTemp > 42){
            model.addAttribute("image","img/FeverBrain.png");
            model.addAttribute("information","Your body temperature are " + bodyTemp +"!");
            model.addAttribute("info","This high body temperature is deadly");
            model.addAttribute("info2","You are probably unconscious");
            model.addAttribute("info3","If you are a male, DO worry!! You are going to die!");
            model.addAttribute("info4","Bye..");
            return "fever";
        }


        return "redirect:bodytemp";
    }

}
