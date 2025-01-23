/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming;

/**
 *
 * @author User
 */
public class Mammal extends Animal {
    private boolean fur;
    
    public Mammal(String species, String name, String habitat, String dob, double weight, boolean fur) {
        super(species, name, habitat, dob, weight);
        this.fur = fur;
    }
}
