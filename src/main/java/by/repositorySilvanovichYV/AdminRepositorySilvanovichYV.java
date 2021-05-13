package by.repositorySilvanovichYV;

import by.modelSilvanovichYV.AdminSilvanovichYV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepositorySilvanovichYV extends JpaRepository<AdminSilvanovichYV, Integer> {
    List<AdminSilvanovichYV> findByNameAndAccess(String name, String access);
}
