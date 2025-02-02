/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author User
 */
public class Fish extends Animal {
    private int fins;
    private String waterType;
    
    private static final List<String> VALID_WATER_TYPES = Arrays.asList(
        "Fresh Water",
        "Salt Water"
    );
    
    public Fish(String species, String name, String habitat, String dob, double weight, int fins, String waterType) {
        super(species, name, habitat, dob, weight);
        
        // Call local validator
        validateLocalProperties(name, dob, fins, waterType);
        
        this.fins = fins;
        this.waterType = waterType;
    }

    @Override
    public String toString() {
        return super.toString() + ", fins = " + fins + ", waterType = " + waterType;
    }
    
    // This method validates local fields
    private void validateLocalProperties(String name, String dob, int fins, String waterType) {
        // Validates number of fins
        if (fins <= 0 || fins > 100) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Provide a valid number of fins.");
        }
        
        // Validates if waterType is a valid value
        if (VALID_WATER_TYPES.stream().noneMatch(wt -> wt.equalsIgnoreCase(waterType))) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Invalid water type, must be one of: " + VALID_WATER_TYPES);
        }
    }
}
