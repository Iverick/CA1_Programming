/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ca1_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author User
 */
public class CA1_Programming {

    public static void main(String[] args) {
        String inputFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "animals.txt").toAbsolutePath().toString();
        System.out.println(inputFilePath);

        List<Animal> animals = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
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

                System.out.println(Arrays.toString(detailsLine));

                System.out.println(type);

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

                        animals.add(new Mammal(species, name, habitat, dob, weight, fur, stripes));
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
                        
                        animals.add(new Fish(species, name, habitat, dob, weight, fins, waterType));
                        break;
                        
                    case "Reptile":
                        Boolean scales = null;
                        int legs = 0;
                        
                        for (int i = 0; i < detailsLine.length; i++) {
                            if (detailsLine[i].equals("Scales")) {
                                scales = Boolean.parseBoolean(detailsLine[i + 1]);
                            } else if (detailsLine[i].equals("Legs")) {
                                legs = Integer.parseInt(detailsLine[i + 1]);
                            }
                        }
                        
                        animals.add(new Reptile(species, name, habitat, dob, weight, scales, legs));
                        break;
                        
                    case "Bird":
                        double wingspan = 0.0;
                        Boolean migratory = null;
                        
                        for (int i = 0; i < detailsLine.length; i++) {
                            if (detailsLine[i].equals("Wingspan")) {
                                String winspanString = detailsLine[i + 1];
                                winspanString = winspanString.replaceAll("[^0-9.]", "");
                                wingspan = Double.parseDouble(winspanString);
                            } else if (detailsLine[i].equals("Migratory")) {
                                migratory = Boolean.parseBoolean(detailsLine[i + 1]);
                            }
                        }
    
                        animals.add(new Bird(species, name, habitat, dob, weight, wingspan, migratory));
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
