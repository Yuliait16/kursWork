package by.controllerSilvanovichYV;

import by.modelSilvanovichYV.CustomerSilvanovichYV;
import by.modelSilvanovichYV.DeliveriesSilvanovichYV;
import by.modelSilvanovichYV.flower.FlowerSilvanovichYV;
import by.serviceSilvanovichYV.CustomerService;
import by.serviceSilvanovichYV.DeliveryService;
import by.serviceSilvanovichYV.FlowerService;
import by.validatotsSilvanovichJV.DateNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DeliveryControllerSilvanovichYV {
    private final FlowerService flowerService;
    private final CustomerService customerService;
    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryControllerSilvanovichYV(FlowerService flowerService, CustomerService customerService, DeliveryService deliveryService) {
        this.flowerService = flowerService;
        this.customerService = customerService;
        this.deliveryService = deliveryService;
    }

    @GetMapping("/deliveries")
    public String findAll(Model model){
        List<DeliveriesSilvanovichYV> deliveries = deliveryService.findAll();
        model.addAttribute("deliveries", deliveries);
        return "delivery-list";
    }

    @GetMapping("/delivery")
    public String createDeliveryForm(DeliveriesSilvanovichYV delivery, @RequestParam("flowerId")String id, Model model){
        model.addAttribute("flowerId",id);
        model.addAttribute("delivery",delivery);
        return "delivery";
    }

    @PostMapping("/delivery-create")
    public String createDelivery(DeliveriesSilvanovichYV delivery, @RequestParam("flowerId")String id, @RequestParam("login")String customer, Model model){
        //System.out.println(login);
        //Deliveries deliveries=new Deliveries();
        //List<Customer> customer1 = customerService.findByEmail2(customer);

        List<CustomerSilvanovichYV> customer1 = customerService.findByEmail2(customer);
        DateNow date = new DateNow();
        String date1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        delivery.setId_customer(customer1.get(0));
        //delivery.setId_customer(customer1.get(0));
        FlowerSilvanovichYV flower=flowerService.findById(Integer.parseInt(id));
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

    @PostMapping("/delivery-create")
    public String createDelivery(@RequestParam("login")String customer,
                                    @RequestParam("flower")String flower,
                                    @RequestParam("date_of_delivery")String date_of_delivery,
                                    @RequestParam("address")String address,
                                    @RequestParam("expirationdate")String expirationdate,
                                    @RequestParam("securitycode")Integer securitycode,
                                    @RequestParam("cardnumber")String cardnumber){
        System.out.println(customer+flower+address+date_of_delivery+expirationdate+securitycode+cardnumber);
        ErrorStrategy errorStrategy = null;
        
        

        Deliveries deliveries = new Deliveries();

        List<Customer> customer1 = customerService.findByEmail2(customer);

        deliveries.setId_customer(customer1.get(0));

        Flower departureFlowerObject = flowerService.findByName(flower);

        deliveries.setId_flower(departureFlowerObject);

        deliveries.setAddress(address);

        deliveries.setDate_of_delivery(date_of_delivery);
        deliveries.setExpirationdate(expirationdate);

        deliveries.setSecuritycode(securitycode);
        deliveries.setCardnumber(cardnumber);

        deliveryService.saveDelivery(deliveries);


        return "redirect:/deliveries";
    }
}
