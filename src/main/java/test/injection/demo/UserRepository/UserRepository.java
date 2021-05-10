package test.injection.demo.UserRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import test.injection.demo.Entity.Animals;

public interface UserRepository extends CrudRepository<Animals,Integer>{
    
    @Query(nativeQuery=true,value="SELECT * FROM animals WHERE name=:name")
    List<Animals> findByname(String name);

}
