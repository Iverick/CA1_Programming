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
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CA1_Programming {

    public static void main(String[] args) {
        String inputFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "animals.txt").toAbsolutePath().toString();

        // Use local method to populate animals List with the data read from the input file
        List<Animal> animals = parseInputFile(inputFilePath);
        
        Scanner sc = new Scanner(System.in);
        String quit = "quit";
        String userInput = "";
        
        System.out.println("");
        System.out.println("Successfully import animals from the file!");
        System.out.println("You can now search for an animal in our storage.");
        System.out.println("Please enter a search query in the following format - '<parameter>=<value>'");
        System.out.println("For example 'type=Animal'");
        System.out.println("");
        System.out.println("Type 'quit' if you want to terminate this program.");
        System.out.println("");
        
        // Allows an interaction with the user via command shell until the user types 'quit'
        do {
            userInput = sc.nextLine();

            for (Animal animal : animals) {
                System.out.println(animal.toString());
            }
        } while (!userInput.equals(quit));
    }

    private static List<Animal> parseInputFile(String inputFilePath) {
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

                        // Same as for other classes but with different properties
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

                        // Same as for other classes but with different properties
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

        return animals;
    }

    // TODO: Validations
//    private static String validateSpecies(String species) {
//        try {
//            species.matches("[A-Za-z ]+");
//
//            return species;
//        } catch (IllegalArgumentException e) {
//            System.err.println("The species must be text only: " + species);
//
//            throw new IllegalArgumentException();
//        }
//    }
}
