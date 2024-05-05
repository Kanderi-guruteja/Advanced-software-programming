/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author 18722
 */
public class AbstractJPATest {
    
     private static EntityManagerFactory emf;

    /**
     *
     */
    protected EntityManager em;

    /**
     *
     */
    protected EntityTransaction tx;

    /**
     *
     */
    @BeforeAll
    public static void beforeALL() {
        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
    }

    /**
     *
     */
    @BeforeEach
    public void beforeEach() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Car c1 = new Car("bmw", LocalDate.of(2022, 12, 10), CarType.PETROL);

        tx.begin();
        em.persist(c1);
        tx.commit();
    }
    
    /**
     *
     */
    @AfterEach
    public void afterEach() {
        
       
        Car c = em.createQuery("select c from Car c where c.name='bmw'", Car.class).getSingleResult();

        tx.begin();
        em.remove(c);
        tx.commit();
    }

    /**
     *
     */
    @AfterAll
    public static void afterALL() {
        emf.close();
    }
    
    
}
