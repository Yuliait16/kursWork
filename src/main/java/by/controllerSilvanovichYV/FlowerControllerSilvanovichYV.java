package by.controllerSilvanovichYV;

import by.modelSilvanovichYV.flower.FlowerSilvanovichYV;
import by.serviceSilvanovichYV.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class FlowerControllerSilvanovichYV {

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/images/uploads";
    private final FlowerService flowerService;

    @Autowired
    public FlowerControllerSilvanovichYV(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping("/flowers")
    public String findAll(Model model){
        List<FlowerSilvanovichYV> flowers = flowerService.findAll();
        model.addAttribute("flowers", flowers);
        return "flower1-list";
    }

    @GetMapping("/sort-asc")
    public String findAllASC(Model model){
        List<FlowerSilvanovichYV> flowers = flowerService.findAllSorted("asc");
        model.addAttribute("flowers", flowers);
        return "flower-customer";
    }

    @GetMapping("/sort-desc")
    public String findAllDESC(Model model){
        List<FlowerSilvanovichYV> flowers = flowerService.findAllSortedDesc("desc");
        model.addAttribute("flowers", flowers);
        return "flower-customer";
    }
    @GetMapping("/flower-create")
    public String createFlowerForm(Flower flower){
        return "flower-create.html";
    }

    @PostMapping("/flower-create")
    public String createFlower(FlowerSilvanovichYV flower, @RequestParam("file") MultipartFile file){

        try {

            String fileName = file.getOriginalFilename();
            String filePath = Paths.get(uploadDirectory, fileName).toString();

           
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
            stream.write(file.getBytes());
            stream.close();

            flower.setPicture("/images/uploads/"+fileName);

            flowerService.saveFlower(flower);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/flowers";
    }


    @GetMapping("flower-delete/{id}")
    public String deleteFlower(@PathVariable("id") Integer id){
        flowerService.deleteById(id);
        return "redirect:/flowers";
    }

    @GetMapping("flower-update/{id}")
    public String updateFlowerForm(@PathVariable("id") Integer id, Model model){
        FlowerSilvanovichYV flower =flowerService.findById(id);
        model.addAttribute("flower",flower);
        return "/flower-update";
    }
    @GetMapping("/flower-search")
    public String createCustomerForm(Flower flower){
        return "redirect:/flower-customer";
    }

    @PostMapping("/flower-update")
    public String updateFlower(FlowerSilvanovichYV flower){
        flowerService.saveFlower(flower);
        return "redirect:/flowers";
    }

    @GetMapping("/flower-search")
    public String findByTypeLike(FlowerSilvanovichYV flower){

        return "/customer/flower-search";
    }
    @PostMapping("/found-flowers")
    public String foundForCustomer(FlowerSilvanovichYV flower, Model model){
        List<FlowerSilvanovichYV> flowers = flowerService.findByType(flower.getType());
        model.addAttribute("flowers", flowers);
        return "/flower-customer";
    }

    @GetMapping("/flower-customer")
    public String findAllFlowers(Model model){
        List<FlowerSilvanovichYV> flowers = flowerService.findAll();
        model.addAttribute("flowers", flowers);
        return "flower-customer";
    }
    @GetMapping("/flower-filter")
    public String ByTypeLike(FlowerSilvanovichYV flower){

        return "flower-customer";
    }
    @PostMapping("/flower-filter-input")
    public String findAllFilterInput(@Param("min")String min, @Param("max")String max, Model model){
        List<FlowerSilvanovichYV> flowers = flowerService.findAllFiltered(min,max);
        model.addAttribute("flowers", flowers);
        return "/flower-customer";
    }
    @GetMapping("/flower-customerb")
    public String findAllFlowersb(Model model){
        List<FlowerSilvanovichYV> flowers = flowerService.findAll();
        model.addAttribute("flowers", flowers);
        return "flower-customerb";
    }
}
