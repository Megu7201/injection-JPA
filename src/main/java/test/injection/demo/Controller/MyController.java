package test.injection.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import test.injection.demo.Entity.Animals;
import test.injection.demo.UserRepository.UserRepository;

@RestController
public class MyController{
    
    @Autowired 
    private UserRepository repo;
    // 等同於
    // private UserRepository repo;
    // Mycontroller(UserRepository repo){
    // this.repo = repo;
    // }

    @GetMapping("/all")
    public Iterable<Animals> getAllAnimals(){
        return repo.findAll();
    }

    @GetMapping("/animal/{id}")
    public Optional<Animals> getAnimal(@PathVariable Integer id){
        return repo.findById(id);
    }


    @GetMapping("/animals/{id}")
    public List<Animals> getAnimals(@PathVariable String id){
        return repo.findByname(id); 
    }

}