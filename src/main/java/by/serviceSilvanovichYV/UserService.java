package by.serviceSilvanovichYV;

import by.modelSilvanovichYV.UserSilvanovichYV;
import by.repositorySilvanovichYV.UserRepositorySilvanovichYV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepositorySilvanovichYV userRepository;

    @Autowired
    public UserService(UserRepositorySilvanovichYV userRepository){
        this.userRepository = userRepository;
    }

    public UserSilvanovichYV findById(Integer id){
        return userRepository.getOne(id);
    }

    public List<UserSilvanovichYV> findAll(){
        return userRepository.findAll();
    }

    public UserSilvanovichYV saveUser(UserSilvanovichYV user){
        return userRepository.save(user);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }
}
