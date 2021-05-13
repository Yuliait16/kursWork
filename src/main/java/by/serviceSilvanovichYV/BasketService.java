package by.serviceSilvanovichYV;

import by.modelSilvanovichYV.BasketSilvanovichYV;
import by.modelSilvanovichYV.CustomerSilvanovichYV;
import by.repositorySilvanovichYV.BasketRepositorySilvanovichYV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    private final BasketRepositorySilvanovichYV basketRepository;

    @Autowired
    public BasketService(BasketRepositorySilvanovichYV basketRepository){
        this.basketRepository = basketRepository;
    }

    public BasketSilvanovichYV findById(Integer id){
        return basketRepository.getOne(id);
    }

    public List<BasketSilvanovichYV> findAll(){
        return basketRepository.findAll();
    }

    public BasketSilvanovichYV saveBasket(BasketSilvanovichYV basket){
        return basketRepository.save(basket);
    }

    public void deleteById(Integer id){
        basketRepository.deleteById(id);
    }

    public List<BasketSilvanovichYV> findAllByCustomerId(CustomerSilvanovichYV id){
        return basketRepository.findBasketById_customer(id);
    }
}
