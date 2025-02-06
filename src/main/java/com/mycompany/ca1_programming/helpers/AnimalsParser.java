/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming.helpers;

import com.mycompany.ca1_programming.Animal;
import com.mycompany.ca1_programming.Bird;
import com.mycompany.ca1_programming.Fish;
import com.mycompany.ca1_programming.Mammal;
import com.mycompany.ca1_programming.Reptile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AnimalsParser {
    public static List<Animal> parseAnimals() {
        // Creates a string that contains a path to an animal.txt file
        String inputFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "animals.txt").toAbsolutePath().toString();
        
        return parseInputFile(inputFilePath);
    }
    
    // This method reads lines in an input file and tries to convert file content into a List of Animal objects.
    private static List<Animal> parseInputFile(String inputFilePath) {
        // Create an empty animals List
        List<Animal> animals = new ArrayList<>();

        // Use try/catch block to read lines in an input file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Read first line
                String[] speciesNameLine = line.split(",");
                String type = speciesNameLine[0];
                String species = speciesNameLine[1];
                String name = speciesNameLine[2];

                // Read second line
                String habitat = bufferedReader.readLine();

                // Read third line
                String[] dobWeightLine = bufferedReader.readLine().split(",");
                String dob = dobWeightLine[0];
                double weight = Double.parseDouble(dobWeightLine[1]);

                // Read fourth line
                String[] detailsLine = bufferedReader.readLine().split(",");

                // To populate animal with unique values for each type from the details line
                // I have to use switch to differentiate between them
                switch (type) {
                    case "Mammal":
                        Boolean fur = null;
                        Boolean stripes = null;

                        // Iterate over data read in the fourth line to find the a property name specific for Mammal type
                        // and its value in the next element in the array
                        for (int i = 0; i < detailsLine.length; i++) {
                            if (detailsLine[i].equals("Fur")) {
                                fur = Boolean.parseBoolean(detailsLine[i + 1]);
                            } else if (detailsLine[i].equals("Stripes")) {
                                stripes = Boolean.parseBoolean(detailsLine[i + 1]);
                            }
                        }

                        // Create a new object of class Mammal with parsed values
                        try {
                            animals.add(new Mammal(species, name, habitat, dob, weight, fur, stripes));
                        } catch (IllegalArgumentException error) {
                            System.err.println("Error creating an animal: " + error);
                            System.out.println("");
                        }
                        break;

                    case "Fish":
                        int fins = 0;
                        String waterType = null;

                        // Same as for Mammal but with different properties
                        for (int i = 0; i < detailsLine.length; i++) {
                            if (detailsLine[i].equals("Fins")) {
                                fins = Integer.parseInt(detailsLine[i + 1]);
                            } else if (detailsLine[i].equals("Water Type")) {
                                waterType = detailsLine[i + 1];
                            }
                        }

                        try {
                            animals.add(new Fish(species, name, habitat, dob, weight, fins, waterType));
                        } catch (IllegalArgumentException error) {
                            System.err.println("Error creating an animal: " + error);
                            System.out.println("");
                        }
                        break;

                    case "Reptile":
                        Boolean scales = null;
                        int legs = 0;

                        // Same as for other classes but with different properties
                        for (int i = 0; i < detailsLine.length; i++) {
                            if (detailsLine[i].equals("Scales")) {
                                scales = Boolean.parseBoolean(detailsLine[i + 1]);
                            } else if (detailsLine[i].equals("Legs")) {
                                legs = Integer.parseInt(detailsLine[i + 1]);
                            }
                        }

                        try {
                            animals.add(new Reptile(species, name, habitat, dob, weight, scales, legs));
                        } catch (IllegalArgumentException error) {
                            System.err.println("Error creating an animal: " + error);
                            System.out.println("");
                        }
                        break;

                    case "Bird":
                        Double wingspan = null;
                        Boolean migratory = null;

                        // Same as for other classes but with different properties
                        for (int i = 0; i < detailsLine.length; i++) {
                            if (detailsLine[i].equals("Wingspan")) {
                                // Do the following to remove all non numerical values from the string to convert it into double value
                                String winspanString = detailsLine[i + 1];
                                winspanString = winspanString.replaceAll("[^0-9.]", "");
                                wingspan = Double.parseDouble(winspanString);
                            } else if (detailsLine[i].equals("Migratory")) {
                                migratory = Boolean.parseBoolean(detailsLine[i + 1]);
                            }
                        }

                        try {
                            animals.add(new Bird(species, name, habitat, dob, weight, wingspan, migratory));
                        } catch (IllegalArgumentException error) {
                            System.err.println("Error creating an animal: " + error);
                            System.out.println("");
                        }
                        break;
                    default:
                        System.out.println("Error: Invalid animal type '" + type + "'. Allowed values: Mammal, Fish, Reptile, Bird.");
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return animals;
    }
}
