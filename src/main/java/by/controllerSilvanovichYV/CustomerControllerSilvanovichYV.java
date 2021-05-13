package by.controllerSilvanovichYV;

import by.mail.EmailSilvanovichYV;
import by.modelSilvanovichYV.CustomerSilvanovichYV;
import by.serviceSilvanovichYV.AdminService;
import by.serviceSilvanovichYV.CustomerService;
import by.strategy.*;
import by.validatotsSilvanovichJV.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerControllerSilvanovichYV {
    private String errorMess;
    private final CustomerService customerService;
    private final AdminService adminService;
    EmailValidator validator = new EmailValidator();


    @Autowired
    public CustomerControllerSilvanovichYV(CustomerService customerService, AdminService adminService) {
        this.customerService = customerService;
        this.adminService = adminService;
    }

    @GetMapping("/customers")
    public String findAll(Model model){
        List<CustomerSilvanovichYV> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/forgot_password")
    public String forgotPassword(CustomerSilvanovichYV customer){
        return "forgot";
    }

    @GetMapping("/auth")
    public String createCustomerForm(CustomerSilvanovichYV customer){
        return "auth";
    }

    @PostMapping("/customer-create")
    public String createCustomer(CustomerSilvanovichYV customer, Model model){

        for(char c : customer.getName().toCharArray()){
            if(Character.isDigit(c)){
                ErrorStrategy errorStrategy = new ErrorName();
                errorMess = errorStrategy.validRegistration();
                return "redirect:/auth-error";
            }
            if(!Character.isAlphabetic(c)) {
                ErrorStrategy errorStrategy = new ErrorName();
                errorMess = errorStrategy.validRegistration();
                return "redirect:/auth-error";
            }
        }
        if(!validator.validate(customer.getEmail())){
            ErrorStrategy errorStrategy = new ErrorEmail();
            errorMess = errorStrategy.validRegistration();
            return "redirect:/auth-error";
        }
        if(customer.getAccess().length()<6){
            ErrorStrategy errorStrategy = new ErrorPassword();
            errorMess = errorStrategy.validRegistration();
            return "redirect:/auth-error";
        }

        customerService.saveCustomer(customer);
        return "index";
    }
    @GetMapping("/auth-error")
    public String createCustomerFormWithError(CustomerSilvanovichYV customer, Model model){
        model.addAttribute("error",errorMess);
        return "auth";
    }

    @PostMapping("/entrance")
    public String entrance(CustomerSilvanovichYV customer, Model model){

        if(adminService.findByNameAndAccess(customer.getEmail(),customer.getAccess()).size()!=0)
            return "redirect:admin-profile";

        if(customerService.findByEmail(customer.getEmail(),customer.getAccess()).size()!=0) {
            String customer_email = customer.getEmail();
            model.addAttribute("customer_email",customer_email);
            return "customer-menu";
        }
        ErrorStrategy errorStrategy = new ErrorAuthorisation();
        errorMess = errorStrategy.validRegistration();
        return "redirect:/auth-error";
    }

    @PostMapping("/forgot-password")
    public String forgot(CustomerSilvanovichYV customer) {
        List<CustomerSilvanovichYV> customers = customerService.findByEmail2(customer.getEmail());
        if(customers.size()!=0){
            EmailSilvanovichYV.mail(customer.getEmail(),customers.get(0).getAccess(), customers.get(0).getName());

            ErrorStrategy errorStrategy = new ErrorWarning();
            errorMess = errorStrategy.validRegistration();
            return "redirect:/auth-error";

        }
        ErrorStrategy errorStrategy = new ErrorInvalidEmail();
        errorMess = errorStrategy.validRegistration();
        return "redirect:/auth-error";
    }



    @GetMapping("/about-us")
    public String aboutUs(Model model){
        BufferedReader objReader = null;
        String response = "";
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader("C:\Users\MiGaming\about-us.txt"));
            while ((strCurrentLine = objReader.readLine())!=null) {
                response+=strCurrentLine+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        model.addAttribute("about", response);
        return "/about-us";
    }
}
