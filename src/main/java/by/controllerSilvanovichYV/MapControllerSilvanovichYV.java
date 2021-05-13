package by.controllerSilvanovichYV;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapControllerSilvanovichYV {
    @GetMapping("/map")
    public  String returnMap(){
        return "map";
    }
}
