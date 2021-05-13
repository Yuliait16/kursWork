package by.serviceSilvanovichYV;


import by.modelSilvanovichYV.DeliveriesSilvanovichYV;
import by.repositorySilvanovichYV.DeliveryRepositorySilvanovichYV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryRepositorySilvanovichYV deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepositorySilvanovichYV deliveryRepository){
        this.deliveryRepository = deliveryRepository;
    }

    public DeliveriesSilvanovichYV findById(Integer id){
        return deliveryRepository.getOne(id);
    }

    public List<DeliveriesSilvanovichYV> findAll(){
        return deliveryRepository.findAll();
    }

    public DeliveriesSilvanovichYV saveDelivery(DeliveriesSilvanovichYV delivery){
        return deliveryRepository.save(delivery);
    }

    public void deleteById(Integer id){
        deliveryRepository.deleteById(id);
    }
}