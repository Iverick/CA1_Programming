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
 * @author Pavel
 */
public class CA1_Programming {

    public static void main(String[] args) {
        String inputFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "animals.txt").toAbsolutePath().toString();

        // Use local method to populate animals List with the data read from the input file
        List<Animal> animals = parseInputFile(inputFilePath);

        // Call following function to interact with the user
        displaySearchInstructions(animals.size() > 0);
        interactWithUser(animals);
    }

    private static void displaySearchInstructions(Boolean isAnimalsEmpty) {
        System.out.println("");
        System.out.println("Successfully import animals from the file!");

        // Check if our animals list contains any value and display different messages to the User.
        if (isAnimalsEmpty) {
            System.out.println("You can now search for an animal by its type, species, habitat or name in our storage.");
            System.out.println("Please enter a search query in the following format - '<parameter>=<value>'");
            System.out.println("For example 'type=Mammal'");
            System.out.println("Enter '*' if you want to see a list of all animals.");
            System.out.println("");
        } else {
            System.out.println("But it doesn't store any value.");
            System.out.println("");
        }

        System.out.println("Type 'quit' if you want to terminate this program.");
        System.out.println("");
    }

    private static void interactWithUser(List<Animal> animals) {
        // Declare required local variables
        String quit = "quit";
        String displayAll = "*";
        String userInput;
        List<Animal> animalsSearchResult;
        String[] searchProperties = {"type", "species", "habitat", "name"};
        String seachQueryRegex = "^[a-zA-Z]+=[a-zA-Z0-9 ]+$";

        Scanner sc = new Scanner(System.in);

        // Use do while loop to interact with the user via command shell until the user types 'quit'
        do {
            // Read user input
            userInput = sc.nextLine();
            System.out.println("");

            // Displays all animals
            if (userInput.equals(displayAll)) {
                System.out.println("The list of all animals added to our storage.");
                System.out.println("");
                for (Animal animal : animals) {
                    System.out.println(animal.toString());
                }
                System.out.println("");
                System.out.println("Please enter a search query or type 'quit' to leave this program.");
                System.out.println("");
                continue;
            }

            // Check if provided search query matches required format
            if (!userInput.matches(seachQueryRegex)) {
                System.out.println("Please provide a proper search query in the following format '<parameter>=<value>' or type 'quit'.");
                System.out.println("");
                continue;
            }

            // Parse user input and add it to an inputAttributes array
            String[] inputAttributes = userInput.split("=");
            String searchKey = inputAttributes[0];
            String searchValue = inputAttributes[1];

            // Check if we can perform a search with the provided search key
            if (!Arrays.asList(searchProperties).contains(searchKey)) {
                System.out.println("Cannot perform search with a provided parameter - " + searchKey + ".");
                System.out.println("");
                continue;
            }

            // Call static searchAnimals method to perform a search on the list of animals and assign the result to searchResult list.
            animalsSearchResult = searchAnimals(animals, searchKey, searchValue);

            if (!animalsSearchResult.isEmpty()) {
                // Display the list of animals that match the search criteria
                for (Animal foundAnimal : animalsSearchResult) {
                    System.out.println("Following animals were found.");
                    System.out.println("#####################################################################");
                    System.out.println(foundAnimal.toString());
                    System.out.println("");
                }
            } else {
                // Display the following message if no animals match.
                System.out.println("Could not find animals for your search query - " + userInput + ".");
                System.out.println("");
            }

            System.out.println("Please enter a search query or type 'quit' to leave this program.");
            System.out.println("");
        } while (!userInput.equals(quit));
    }

    private static List<Animal> searchAnimals(List<Animal> animals, String searchKey, String searchValue) {
        List<Animal> animalMatches = new ArrayList<>();

        // Loop over each animal to find if it matches the search query
        for (Animal animal : animals) {
            // Use switch to iterate between allowed search keys
            switch (searchKey.toLowerCase()) {
                case "type":
                    // If animal's type matches the search value add it to the matches list
                    if (animal.getClass().getSimpleName().equalsIgnoreCase(searchValue)) {
                        animalMatches.add(animal);
                    }
                case "habitat":
                    // Same as the previous step but for a different Animal property
                    if (animal.getHabitat().equalsIgnoreCase(searchValue)) {
                        animalMatches.add(animal);
                    }
                case "name":
                    if (animal.getName().equalsIgnoreCase(searchValue)) {
                        animalMatches.add(animal);
                    }
                case "species":
                    if (animal.getSpecies().equalsIgnoreCase(searchValue)) {
                        animalMatches.add(animal);
                    }
            }
        }

        return animalMatches;
    }

    private static List<Animal> parseInputFile(String inputFilePath) {
        List<Animal> animals = new ArrayList<>();

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
