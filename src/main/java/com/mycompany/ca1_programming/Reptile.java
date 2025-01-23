/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming;

/**
 *
 * @author User
 */
public class Reptile extends Animal {
    private boolean scales;
    private int legs;
    
    public Reptile(String species, String name, String habitat, String dob, double weight, boolean scales, int legs) {
        super(species, name, habitat, dob, weight);
        this.scales = scales;
        this.legs = legs;
    }
}
