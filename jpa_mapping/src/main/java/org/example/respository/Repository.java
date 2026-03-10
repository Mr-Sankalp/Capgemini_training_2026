package org.example.respository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Repository {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("yashashvi");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeFactory() {
        emf.close();
    }
}