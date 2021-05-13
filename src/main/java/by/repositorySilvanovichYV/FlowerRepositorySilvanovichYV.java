package by.repositorySilvanovichYV;

import by.modelSilvanovichYV.flower.FlowerSilvanovichYV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlowerRepositorySilvanovichYV extends JpaRepository<FlowerSilvanovichYV, Integer> {
     FlowerSilvanovichYV findByName(String name);

     @Query("SELECT c FROM FlowerSilvanovichYV c WHERE c.type LIKE %?1%")
     List<FlowerSilvanovichYV> findAllByType(String type);

     @Query("SELECT c FROM FlowerSilvanovichYV c WHERE c.price BETWEEN ?1 AND ?2")
     List<FlowerSilvanovichYV> findAllFiltered(String min, String max);


}
