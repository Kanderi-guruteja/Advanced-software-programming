/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author 18722
 */


public class CarJPATest extends AbstractJPATest{

    /**
     *
     */
    @Test
    public void createTest() {
        Car c2 = new Car("merc", LocalDate.of(2022, 12, 10), CarType.PETROL);
        Car c3 = new Car("audi", LocalDate.of(2022, 12, 10), CarType.DIESEL);

        tx.begin();
        em.persist(c2);
        tx.commit();
        
         tx.begin();
        em.persist(c3);
        tx.commit();
        
        
        Car readBackFromDatabaseForAssertion = em.find(Car.class, c2.getId());
        assertEquals(c2.getId(), readBackFromDatabaseForAssertion.getId());
        }

    /**
     *
     */
    @Test
    public void readTest() {
         
    
    String carNameToRead = "bmw"; 

    tx.begin();
    Car car = em.createQuery("SELECT c FROM Car c WHERE c.name = :name", Car.class)
                .setParameter("name", carNameToRead)
                .getSingleResult();
    tx.commit();

    Assertions.assertNotNull(car, "Car entity with name '" + carNameToRead + "' not found");
     System.out.println("Read entity details:");
    System.out.println("ID: " + car.getId());
    System.out.println("Name: " + car.getName());
    System.out.println("Buy Date: " + car.getBuyDate());
    System.out.println("Type: " + car.getType());
}

    /**
     *
     */
    @Test
    public void upadteTest() { 
        
        
        Car c2 = em.createQuery("select c from Car c where c.name='merc'", Car.class).getSingleResult();
        LocalDate newBuyday = LocalDate.of(2023,10,01);
       
        tx.begin();
        c2.setBuyDate(newBuyday);
        tx.commit();
         
           Car readBackFromDatabaseForAssertion = em.find(Car.class, c2.getId());
           
           
           
         assertEquals(newBuyday, readBackFromDatabaseForAssertion.getBuyDate()); 
         
    }

    /**
     *
     */
    @Test
    public void deleteTest() { 
          Car audi = em.createQuery("SELECT c FROM Car c WHERE c.name = :name", Car.class)
                .setParameter("name", "audi")
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(audi, "AUDI entity not found");

        tx.begin();
        em.remove(audi);
        tx.commit();

        Car deletedAudi = em.find(Car.class, audi.getId());
        Assertions.assertNull(deletedAudi, "AUDI entity still exists after deletion"); 
    }
    
    /**
     *
     */
    @Test
    public void uniDirectionalRelationshipTest(){
    
    
    }
    
    /**
     *
     */
    @Test
    public void biDirectionalRelationshipTest(){}
    

    
}
