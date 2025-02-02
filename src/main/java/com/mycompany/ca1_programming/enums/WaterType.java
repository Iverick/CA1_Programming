/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming.enums;

/**
 *
 * @author User
 */
public enum WaterType {
    // List of water type values
    FRESH_WATER, SALT_WATER;
    
    // Method checks if provided waterType parameter is among this enum values
    public static boolean isValidWaterType(String waterType) {
        for (WaterType type : values()) {
            if (type.name().replace("_", " ").equalsIgnoreCase(waterType)) {
                return true;
            }
        }
        return false;
    }
    
    // Custom toString method
    @Override
    public String toString() {
        String nameString = this.name().replace("_", " ").toLowerCase();
        return nameString.substring(0, 1).toUpperCase() + nameString.substring(1);
    }
}
