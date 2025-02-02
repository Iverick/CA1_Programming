/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

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

    private static final List<String> VALID_HABITATS = Arrays.asList(
            "Cave",
            "Desert",
            "Grassland",
            "Forest",
            "Island",
            "Ocean",
            "Rainfall",
            "Marine",
            "Mountains"
    );
    
    private static final List<String> VALID_TYPES = Arrays.asList("MAMMAL", "FISH", "BIRD", "REPTILE");

    // Constructor method
    public Animal(String species, String name, String habitat, String dob, double weight) {
        // Call local method to validate passed parameters
        validateProperties(species, name, habitat, dob, weight);
     
        // Set object fields
        this.species = species;
        this.name = name;
        this.habitat = habitat;
        this.dob = dob;
        this.weight = weight;
    }

    // Override default toString method
    @Override
    public String toString() {
        return getClass().getSimpleName() + " species = " + species + ", name = " + name + ", habitat = " + habitat + ", dob = " + dob;
    }

    // This helper method is used to provide information about an object for an error message
    protected String getTypeAndName(String name, String dob) {
        return "type=" + getClass().getSimpleName() + ", name=" + name + ", dob=" + dob + ". ";
    }
    
    // This method contains a set of validators for each property we try to assign to an object in the constructor
    private void validateProperties(String species, String name, String habitat, String dob, double weight) {
        // Check if the species value contains letters and spaces only and throw an error with an error message if validation fails
        if (!species.matches("^[a-zA-Z\s]+$")) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Species value must be text only.");
        }

        // Check if the name value contains letters and numbers only
        if (!name.matches("^[a-zA-Z\\d\\s]*$")) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "The name can be text and/or numbers.");
        }

        // Check if habitat is a valid enum value
        if (!VALID_HABITATS.contains(habitat)) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Invalid habitat, must be one of: " + VALID_HABITATS);
        }

        // Check if dob has a valid format
        try {
            LocalDate.parse(dob.replace("/", "-"));
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Invalid DoB format: Must be in the form yyyy/mm/dd ");
        }

        // Check if weight is a positive double value
        if (weight <= 0) {
            throw new IllegalArgumentException(getTypeAndName(name, dob) + "Invalid weight: Must be a positive double.");
        }
    }

    // Getters and setters
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
