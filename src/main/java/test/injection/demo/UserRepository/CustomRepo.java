package test.injection.demo.UserRepository;

import java.util.List;

import test.injection.demo.Entity.Animals;

public interface CustomRepo{
    List<Animals> findMyCustom(String name);
}