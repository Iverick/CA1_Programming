/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming;

/**
 *
 * @author User
 */
public abstract class Animal {
    private String species;
    private String name;
    private String habitat;
    private String dob;
    private double weight;

    public Animal(String species, String name, String habitat, String dob, double weight) {
        this.species = species;
        this.name = name;
        this.habitat = habitat;
        this.dob = dob;
        this.weight = weight;
    }
}
