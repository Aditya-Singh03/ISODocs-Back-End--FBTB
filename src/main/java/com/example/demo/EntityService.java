package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityService {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DATA");

    private static EntityManager em = emf.createEntityManager();

    public static EntityManager getEntityManagerFactory() {
        return em;
    }
    
}

// public class EntityService {
//     private static EntityManagerFactory emf;

//     public static EntityManager getEntityManagerFactory() {
//         emf = Persistence.createEntityManagerFactory("DATA");
//         return emf.createEntityManager();
//     }
    
// }
