package by.repositorySilvanovichYV;

import by.modelSilvanovichYV.BasketSilvanovichYV;
import by.modelSilvanovichYV.CustomerSilvanovichYV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketRepositorySilvanovichYV extends JpaRepository<BasketSilvanovichYV, Integer> {

    @Query("SELECT c FROM Basket c WHERE c.id_customer=?1")
    List<Basket> findBasketById_customer(Customer id);

    @Query("SELECT c FROM BasketSilvanovichYV c  WHERE c.id_customer=?1")
    List<BasketSilvanovichYV> findBasketById_customer(CustomerSilvanovichYV id);
}
