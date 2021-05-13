package by.serviceSilvanovichYV;

import by.modelSilvanovichYV.flower.FlowerSilvanovichYV;
import by.repositorySilvanovichYV.FlowerRepositorySilvanovichYV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {
    private final FlowerRepositorySilvanovichYV flowerRepository;

    @Autowired
    public FlowerService(FlowerRepositorySilvanovichYV flowerRepository){
        this.flowerRepository = flowerRepository;
    }

    public FlowerSilvanovichYV findById(Integer id){
        return flowerRepository.getOne(id);
    }

    public List<FlowerSilvanovichYV> findAll(){
        return flowerRepository.findAll();
    }

    public FlowerSilvanovichYV saveFlower(FlowerSilvanovichYV flower){
        return flowerRepository.save(flower);
    }

    public void deleteById(Integer id){
        flowerRepository.deleteById(id);
    }

    public List<FlowerSilvanovichYV> findAllFlowers(){
        return flowerRepository.findAll();
    }

    public FlowerSilvanovichYV findByName(String name){
        return flowerRepository.findByName(name);
    }

    public List<FlowerSilvanovichYV> findByType(String type){
        return flowerRepository.findAllByType(type);
    }

    public List<FlowerSilvanovichYV> findAllSorted(String order){
        if(order.equals("asc")) return flowerRepository.findAll(Sort.by("price").ascending());
        return flowerRepository.findAll(Sort.by("price").descending());
    }
    public List<FlowerSilvanovichYV> findAllFiltered(String min, String max){

        return flowerRepository.findAllFiltered(min, max);
    }
    public List<FlowerSilvanovichYV> findAllSortedDesc(String order){
        if(order.equals("desc")) return flowerRepository.findAll(Sort.by("price").descending());
        return flowerRepository.findAll(Sort.by("price").descending());
    }

}