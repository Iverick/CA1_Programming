/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming;

/**
 *
 * @author User
 */
public class Fish extends Animal {
    private int fins;
    private String waterType;
    
    public Fish(String species, String name, String habitat, String dob, double weight, int fins, String waterType) {
        super(species, name, habitat, dob, weight);
        this.fins = fins;
        this.waterType = waterType;
    }
}
