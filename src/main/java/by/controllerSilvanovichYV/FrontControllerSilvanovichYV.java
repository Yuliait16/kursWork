package by.controllerSilvanovichYV;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FrontControllerSilvanovichYV {

    @GetMapping("/")
    public String createF() {
        return "index";
    }

}
