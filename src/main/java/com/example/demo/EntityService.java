package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityService {
    EntityManagerFactory emf;

    public static EntityManager getEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DATA");
        return emf.createEntityManager();
    }

    
    
}
