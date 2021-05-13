package by.serviceSilvanovichYV;

import by.modelSilvanovichYV.CustomerSilvanovichYV;
import by.repositorySilvanovichYV.CustomerRepositorySilvanovichYV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepositorySilvanovichYV customerRepository;

    @Autowired
    public CustomerService(CustomerRepositorySilvanovichYV customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerSilvanovichYV findById(Integer id){
        return customerRepository.getOne(id);
    }

    public List<CustomerSilvanovichYV> findAll(){
        return customerRepository.findAll();
    }

    public CustomerSilvanovichYV saveCustomer(CustomerSilvanovichYV customer){
        return customerRepository.save(customer);
    }

    public void deleteById(Integer id){
        customerRepository.deleteById(id);
    }

    public List<CustomerSilvanovichYV> findByEmail(String email, String access){

        return customerRepository.findByEmailAndAccess(email, access);
    }
   // public List<Customer> findByEmail3(String email){

     //   return customerRepository.findByEmail(email);
    //}

    public List<CustomerSilvanovichYV> findByEmail2(String email){
        return customerRepository.findByEmail(email);
    }
}
