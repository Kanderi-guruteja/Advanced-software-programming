/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;
import edu.iit.sat.itmd4515.gkanderi.domain.Leasingoffice;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author 18722
 */
public class JPARelationshipTest extends AbstractJPATest{

    /**
     *
     */
    @Test
    public void uniDirectionalRelationshipTest(){
        Leasingoffice l = new Leasingoffice("Priority Car Leasing"); // Remove the extra space here   
        Salesstaff s = new Salesstaff("Priority salesstaff");
        s.setLeasingoffice(l);
        
        tx.begin();
        em.persist(l);
        em.persist(s);
        tx.commit();
        
        Salesstaff readBackFromDatabase = em.find(Salesstaff.class, s.getId());
        assertNotNull(readBackFromDatabase.getLeasingoffice());
        assertEquals("Priority Car Leasing", readBackFromDatabase.getLeasingoffice().getLeasingofficeName().trim()); 
                
    }
    
    /**
     *
     */
    @Test
    public void biDirectionalRelationshipTest1(){
        // Existing functionality
        Manufacturer m = new Manufacturer("Manufacturer@none.net", "Manufacturer Test", LocalDate.of(1980,2,10));
        Car c = new Car("Mercedes Benz", LocalDate.of(2023, 1, 17), CarType.PETROL);
        m.addCar(c);
        
        tx.begin();
        em.persist(c);
        em.persist(m);
        tx.commit();
        
        System.out.println("Navigating relationship from the owning side" + m.getCars().toString());
        System.out.println("Navigating relationship from the inverse side" + c.getManufacturer().toString());
        
        assertFalse(m.getCars().isEmpty());
        assertTrue(c.getManufacturer().size() == 1);
        
        tx.begin();
        m.removeCar(c);
        em.remove(c);
        em.remove(m);
        tx.commit();
        
        Manufacturer newManufacturer = new Manufacturer("carLeasingoffice@none.net", "New Manufacturer", LocalDate.of(2000, 5, 20));
        Leasingoffice newLeasingoffice = new Leasingoffice("Chicago Car Leasing Office");
        newManufacturer.setLeasingoffice(newLeasingoffice);
        
        tx.begin();
        em.persist(newLeasingoffice);
        em.persist(newManufacturer);
        tx.commit();
        
        Manufacturer newManufacturerFromDB = em.find(Manufacturer.class, newManufacturer.getId());
        System.out.println("Manufacturer from database: " + newManufacturerFromDB);
        assertNotNull(newManufacturerFromDB.getLeasingoffice());
        System.out.println("Leasing office from database: " + newManufacturerFromDB.getLeasingoffice());
        assertEquals("Chicago Car Leasing Office", newManufacturerFromDB.getLeasingoffice().getLeasingofficeName().trim());}
    
    /**
     *
     */
    public void biDirectionalRelationshipTest2(){
        Leasingoffice leasingoffice = new Leasingoffice("Chicago Car Leasing office");
        Salesstaff salesstaff = new Salesstaff("Priority salesstaff");
        
        // Bidirectional relationship setup
        leasingoffice.getSalesstaffList().add(salesstaff);
        salesstaff.setLeasingoffice(leasingoffice);
        
        tx.begin();
        em.persist(leasingoffice);
        em.persist(salesstaff);
        tx.commit();
       
        Leasingoffice leasingofficeFromDB = em.find(Leasingoffice.class, leasingoffice.getId());
        
        System.out.println("Navigating relationship from the owning side: " + leasingofficeFromDB.getSalesstaffList());
        for (Salesstaff staff : leasingofficeFromDB.getSalesstaffList()) {
            System.out.println("Navigating relationship from the inverse side: " + staff.getLeasingoffice());
        }
        
        assertNotNull(leasingofficeFromDB.getSalesstaffList());
        assertTrue(leasingofficeFromDB.getSalesstaffList().size() == 1);
    }
}
