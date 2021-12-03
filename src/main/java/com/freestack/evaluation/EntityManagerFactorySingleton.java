package com.freestack.evaluation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory emf;

    private EntityManagerFactorySingleton() {}

    public static EntityManagerFactory getInstance() {
        if (emf == null) emf = Persistence.createEntityManagerFactory("myPostGreSqlEntityManager");
        return emf;
    }

    @Override
    protected void finalize() throws Throwable {
        emf.close();
    }
}
