/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package edu.iit.sat.itmd4515.gkanderi.domain;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author 18722
 */


public class CarValidationTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    /**
     *
     */
    @BeforeAll
    public static void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    /**
     *
     */
    @AfterAll
    public static void tearDown() {
        validatorFactory.close();
    }

    /**
     *
     */
    @Test
    public void validateCarName_Success() {
        Car car = new Car("Audi", LocalDate.now(), CarType.PETROL);
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertEquals(0, violations.size());
        System.out.println("Validation passed for Car name");
    }

    /**
     *
     */
    @Test
    public void validateCarName_Invalid_Blank() {
        Car car = new Car("", LocalDate.now(), CarType.PETROL);
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertEquals(1, violations.size());
    }

    /**
     *
     */
    @Test
    public void validateCarBuyDate_Success() {
        Car car = new Car("Audi", LocalDate.now(), CarType.PETROL);
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertEquals(0, violations.size());
        System.out.println("Validation passed for Car buy date");
    }

    /**
     *
     */
    @Test
    public void validateCarBuyDate_Invalid_FutureDate() {
        Car car = new Car("Audi", LocalDate.now().plusDays(1), CarType.PETROL);
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertEquals(1, violations.size());
    }

    /**
     *
     */
    @Test
    public void validateCarType_Success() {
        Car car = new Car("Audi", LocalDate.now(), CarType.PETROL);
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertEquals(0, violations.size());
        System.out.println("Validation passed for Car type");
    }

    /**
     *
     */
    @Test
    public void validateCarType_Invalid_Null() {
        Car car = new Car("Audi", LocalDate.now(), null);
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        assertEquals(1, violations.size());
    }
}