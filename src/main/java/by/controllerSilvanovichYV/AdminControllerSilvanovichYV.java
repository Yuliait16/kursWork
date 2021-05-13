package by.controllerSilvanovichYV;

import by.modelSilvanovichYV.AdminSilvanovichYV;
import by.modelSilvanovichYV.flower.FlowerSilvanovichYV;
import by.serviceSilvanovichYV.AdminService;
import by.serviceSilvanovichYV.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminControllerSilvanovichYV {

    private final AdminService adminService;
    private final FlowerService flowerService;

    @Autowired
    public AdminControllerSilvanovichYV(AdminService adminService, FlowerService flowerService) {
        this.adminService = adminService;
        this.flowerService = flowerService;
    }

    @GetMapping("/admins")
    public String findAll(Model model){
        List<AdminSilvanovichYV> admins = adminService.findAll();
        model.addAttribute("admins", admins);
        return "admin-list";
    }


    @GetMapping("/admin-create")
    public String createAdminForm(AdminSilvanovichYV admin){
        return "admin-create.html";
    }

    @GetMapping("/admin-profile")
    public String addAdminForm(AdminSilvanovichYV admin){
        return "admin-profile";
    }

    @GetMapping("/flower-create")
    public String createFlowerForm(FlowerSilvanovichYV flower){
        return "flower-create";
    }

    @PostMapping("/admin-create")
    public String createAdmin(AdminSilvanovichYV admin){
        adminService.saveAdmin(admin);
        return "redirect:/admins";
    }



    @GetMapping("/analys")
    public String analys(){


        return "/analys";
    }
    @GetMapping("/serv")
    public String serv(){


        return "/serv";
    }

    @GetMapping("/seran")
    public String seran(){


        return "/seran";
    }
}
