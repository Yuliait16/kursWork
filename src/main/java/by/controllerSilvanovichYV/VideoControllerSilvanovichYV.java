package by.controllerSilvanovichYV;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoControllerSilvanovichYV {
    @GetMapping("/facts")
    public  String returnMap(){
        return "facts";
    }
}

