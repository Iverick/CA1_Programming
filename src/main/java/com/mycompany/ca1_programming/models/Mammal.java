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
public class Mammal extends Animal {

    private boolean fur;
    private boolean stripes;

    public Mammal(String species, String name, String habitat, String dob, double weight, boolean fur, boolean stripes) {
        super(species, name, habitat, dob, weight);
        
        this.fur = fur;
        this.stripes = stripes;
    }
        
    // Override toString method to additionally display local fields
    @Override
    public String toString() {
        String furString = fur ? "yes" : "no";
        String stripesString = stripes ? "yes" : "no";
        
        return super.toString() + ", fur = " + furString + ", stipes = " + stripesString;
    }
}
