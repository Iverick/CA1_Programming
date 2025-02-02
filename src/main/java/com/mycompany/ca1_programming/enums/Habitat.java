/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming.enums;

/**
 *
 * @author User
 */
public enum Habitat {
    // List of habitat values
    CAVE, DESERT, GRASSLAND, FOREST, ISLAND, OCEAN, RAINFOREST, MARINE, MOUNTAINS;
    
    // Method checks if provided habitat parameter is among this enum values
    public static boolean isValidHabitat(String habitat) {
        for (Habitat h : values()) {
            if (h.name().replace("_", " ").equalsIgnoreCase(habitat)) {
                return true;
            }
        }
        return false;
    }
    
    // Custom toString method
    @Override
    public String toString() {
        // Format the string as "Cave" instead of "CAVE"
        String habitatString = this.name().replace("_", " ").toLowerCase();
        return habitatString.substring(0, 1).toUpperCase() + habitatString.substring(1);
    }
}
