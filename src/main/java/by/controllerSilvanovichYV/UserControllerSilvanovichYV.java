package by.controllerSilvanovichYV;

import by.modelSilvanovichYV.UserSilvanovichYV;
import by.serviceSilvanovichYV.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserControllerSilvanovichYV {

    private final UserService userService;

    @Autowired
    public UserControllerSilvanovichYV(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<UserSilvanovichYV> users = userService.findAll();
        //users = null;
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(UserSilvanovichYV user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(UserSilvanovichYV user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/update-about-us")
    public String updateAboutUs(@RequestParam("about-us")String aboutUs) throws IOException {
        FileWriter writer = new FileWriter("C:\Users\MiGaming\about-us.txt", false);
        writer.write(aboutUs);
        writer.flush();
        return "redirect:/admin-profile";
    }
}
