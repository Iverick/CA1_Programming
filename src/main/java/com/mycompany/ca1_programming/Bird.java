/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming;

/**
 *
 * @author User
 */
public class Bird extends Animal {
    private double wingspan;
    private Boolean migratory;
    
    public Bird(String species, String name, String habitat, String dob, double weight, double wingspan, boolean migratory) {
        super(species, name, habitat, dob, weight);
        
        // Call local validator
        validateLocalProperties(name, dob, wingspan);

        this.wingspan = wingspan;
        this.migratory = migratory;
    }

    // Override toString method to additionally display local fields
    @Override
    public String toString() {
        String migratoryString = migratory ? "yes" : "no";
        
        return super.toString() + ", wingspan = " + wingspan + "cm" + ", migratory = " + migratoryString;
    }

    // This method validates wingspan value
    private void validateLocalProperties(String name, String dob, double wingspan) {
        if (wingspan <= 0 || wingspan > 500.0) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Wingspan must be a valid positive number in centimeters.");
        }
    }
}
