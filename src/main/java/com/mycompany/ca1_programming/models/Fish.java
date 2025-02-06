/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming.models;

import com.mycompany.ca1_programming.models.Animal;
import com.mycompany.ca1_programming.enums.WaterType;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pavel
 */
public class Fish extends Animal {
    private int fins;
    private String waterType;
    
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
        if (!WaterType.isValidWaterType(waterType)) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Invalid water type, must be one of: " + Arrays.toString(WaterType.values()));
        }
    }
}
