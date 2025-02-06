/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming.models;

import com.mycompany.ca1_programming.models.Animal;

/**
 *
 * @author User
 */
public class Reptile extends Animal {
    private boolean scales;
    private int legs;
    
    public Reptile(String species, String name, String habitat, String dob, double weight, boolean scales, int legs) {
        super(species, name, habitat, dob, weight);
        
        // Call local validator
        validateLocalProperties(name, dob, legs);
        
        this.scales = scales;
        this.legs = legs;
    }

    // Override toString method to additionally display local fields
    @Override
    public String toString() {
        return super.toString() + ", scales = " + scales + ", legs = " + legs;
    }

    // This method validates the number of legs
    private void validateLocalProperties(String name, String dob, int legs) {
        // Validates number of legs
        if (legs <= 0) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Provide a valid number of legs.");
        }
    }
}
