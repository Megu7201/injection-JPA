package test.injection.demo.UserRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import test.injection.demo.Entity.Animals;

public class CustomRepoImp implements CustomRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Animals> findMyCustom(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Animals> query = cb.createQuery(Animals.class);
        Root<Animals> animal = query.from(Animals.class);        
        query.select(animal).where(cb.like(animal.get("name"),name));

        return entityManager.createQuery(query).getResultList();
    }

    
}
