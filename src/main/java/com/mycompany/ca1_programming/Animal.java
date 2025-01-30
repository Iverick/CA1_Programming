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
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " species = " + species + ", name = " + name + ", habitat = " + habitat + ", dob = " + dob;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
}
