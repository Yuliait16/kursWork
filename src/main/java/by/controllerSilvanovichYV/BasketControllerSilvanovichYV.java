package by.controllerSilvanovichYV;

import by.modelSilvanovichYV.BasketSilvanovichYV;
import by.modelSilvanovichYV.CustomerSilvanovichYV;
import by.modelSilvanovichYV.flower.FlowerSilvanovichYV;
import by.serviceSilvanovichYV.BasketService;
import by.serviceSilvanovichYV.CustomerService;
import by.serviceSilvanovichYV.DeliveryService;
import by.serviceSilvanovichYV.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BasketControllerSilvanovichYV {

    private final BasketService basketService;
    private final FlowerService flowerService;
    private final CustomerService customerService;
    private final DeliveryService deliveryService;

    @Autowired
    public BasketControllerSilvanovichYV(BasketService basketService, FlowerService flowerService, CustomerService customerService, DeliveryService deliveryService) {
        this.basketService = basketService;
        this.flowerService = flowerService;
        this.customerService = customerService;
        this.deliveryService = deliveryService;
    }

    @GetMapping("/baskets")
    public String findAll(Model model){
        List<BasketSilvanovichYV> baskets = basketService.findAll();
        model.addAttribute("baskets", baskets);
        return "basket-list.html";
    }

    @GetMapping("/basket-create")
    public String createBasketForm(BasketSilvanovichYV basket){
        return "basket-create.html";
    }

    @PostMapping("/basket-create")
    public String createBasket(BasketSilvanovichYV basket){
        basketService.saveBasket(basket);
        return "redirect:/baskets";
    }

    @GetMapping("/basket")
    public String createDeliveryForm(BasketSilvanovichYV basket, @RequestParam("flowerId")String id, @RequestParam("login")String customer, Model model){
        System.out.println("flowr "+id);

        model.addAttribute("flowerId",id);
        model.addAttribute("basket",basket);
        List<CustomerSilvanovichYV> customer1 = customerService.findByEmail2(customer);
        System.out.println("customer "+customer1.get(0));
        //DateNow date = new DateNow();
        //String date1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        basket.setId_customer(customer1.get(0));
        System.out.println("customer"+customer1.get(0));
        //delivery.setId_customer(customer1.get(0));
        FlowerSilvanovichYV flower=flowerService.findById(Integer.parseInt(id));
        //delivery.setId_customer(customerService.findByEmail2(login).get(0));
        basket.setId_flower(flower);
        basket.setName(flower.getName());
        basketService.saveBasket(basket);
        return "redirect:/flower-customerb";
    }

    @GetMapping("basket-delete/{id}")
    public String deleteFlowerFromBasket(@PathVariable("id") Integer id){
        basketService.deleteById(id);
        return "redirect:/basket";
    }

    //@GetMapping("/list-basket")
    //public String findAllFlowersFromBasket(Basket basket,@RequestParam("login")String customer,Model model){
      //  System.out.println("customer"+customer);
      // List<Flower> flowers = basket.
       // model.addAttribute("flowers", flowers);
        //return "/basket";
    //}

    @GetMapping("/list-basket")
    public String findAllMyRoutes(BasketSilvanovichYV basket, Model model){
        List<CustomerSilvanovichYV> customer1 = customerService.findByEmail2("it16@gmail.com");
        List<BasketSilvanovichYV> baskets = basketService.findAllByCustomerId(customer1.get(0));

        //List<Flower> flowers = flowerService.findAllByFlowerId(baskets.get(0).getId_flower());
        System.out.println(customer1.get(0));
        System.out.println(baskets.get(0).getId_flower());
        int dlina=baskets.size();
        System.out.println(dlina);
     // System.out.println(flowers);
        for(int i=0;i<dlina;i++) {
            System.out.println(baskets.get(0).getId_flower());
            FlowerSilvanovichYV flowers = baskets.get(0).getId_flower();
            model.addAttribute("baskets", baskets);
            model.addAttribute("flowers",flowers);
        }
        return "/basket";
    }
    @PostMapping("/delivery-create")
    public String createDelivery(Deliveries delivery,@RequestParam("flowerId")String id,@RequestParam("login")String customer, Model model){
        //System.out.println(login);
        //Deliveries deliveries=new Deliveries();
        //List<Customer> customer1 = customerService.findByEmail2(customer);

        List<Customer> customer1 = customerService.findByEmail2(customer);
        DateNow date = new DateNow();
        String date1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        delivery.setId_customer(customer1.get(0));
        //delivery.setId_customer(customer1.get(0));
        Flower flower=flowerService.findById(Integer.parseInt(id));
        //delivery.setId_customer(customerService.findByEmail2(login).get(0));
        delivery.setId_flower(flower);
        delivery.setCost(flower.getPrice());
        Double sum = flower.getPrice();
        model.addAttribute("date",date1);
        model.addAttribute("sum",sum);
        //delivery.setCost(Double.parseDouble(price));
        //delivery.setId_flower(flowerService.findByName(name));
        deliveryService.saveDelivery(delivery);
        return "about-us";
    }
}
