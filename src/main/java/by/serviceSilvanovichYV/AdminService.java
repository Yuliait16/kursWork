package by.serviceSilvanovichYV;

import by.modelSilvanovichYV.AdminSilvanovichYV;
import by.repositorySilvanovichYV.AdminRepositorySilvanovichYV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepositorySilvanovichYV adminRepository;

    @Autowired
    public AdminService(AdminRepositorySilvanovichYV adminRepository){
        this.adminRepository = adminRepository;
    }

    public AdminSilvanovichYV findById(Integer id){
        return adminRepository.getOne(id);
    }

    public List<AdminSilvanovichYV> findAll(){
        return adminRepository.findAll();
    }

    public AdminSilvanovichYV saveAdmin(AdminSilvanovichYV admin){
        return adminRepository.save(admin);
    }

    public void deleteById(Integer id){
        adminRepository.deleteById(id);
    }

    public List<AdminSilvanovichYV> findByNameAndAccess(String name, String access){

        return adminRepository.findByNameAndAccess(name, access);
    }
}
