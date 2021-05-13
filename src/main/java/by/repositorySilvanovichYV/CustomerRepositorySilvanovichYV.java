package by.repositorySilvanovichYV;

import by.modelSilvanovichYV.CustomerSilvanovichYV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepositorySilvanovichYV extends JpaRepository<CustomerSilvanovichYV, Integer> {

    List<CustomerSilvanovichYV> findByEmailAndAccess(String email, String access);

    List<CustomerSilvanovichYV> findByEmail(String email);

}
