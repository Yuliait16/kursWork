package by;

import by.controllerSilvanovichYV.FlowerControllerSilvanovichYV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication

public class WorkApplicationSilvanovichJV {


    public static void main(String[] args) {
        new File(FlowerControllerSilvanovichYV.uploadDirectory).mkdir();
        SpringApplication.run(WorkApplicationSilvanovichJV.class, args);
    }

}
