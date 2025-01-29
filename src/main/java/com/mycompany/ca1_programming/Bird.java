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
    
    public Bird(String species, String name, String habitat, String dob, double weight, double wingSpan, boolean migratory) {
        super(species, name, habitat, dob, weight);
        this.wingspan = wingSpan;
        this.migratory = migratory;
    }

    @Override
    public String toString() {
        String migratoryString = migratory ? "yes" : "no";
        
        return super.toString() + ", wingspan = " + wingspan + "cm" + ", migratory = " + migratoryString;
    }
}
