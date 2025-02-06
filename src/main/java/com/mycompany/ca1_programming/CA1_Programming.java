package com.mycompany.ca1_programming;

import com.mycompany.ca1_programming.models.Animal;
import com.mycompany.ca1_programming.helpers.AnimalsParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Pavel
 * 
 * Git repo - https://github.com/Iverick/CA1_Programming
 */
public class CA1_Programming {
    public static void main(String[] args) {
        // Call an AnimalsParserc class method to read an input file
        List<Animal> animals = AnimalsParser.parseAnimals();

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
                System.out.println("Cannot perform search with a provided parameter - " + searchKey + ". You can search an animal by its type, specie, habitat or name.");
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
                    System.out.println("#####################################################################");
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
                    break;
                case "habitat":
                    // Same as the previous step but for a different Animal property
                    if (animal.getHabitat().equalsIgnoreCase(searchValue)) {
                        animalMatches.add(animal);
                    }
                    break;
                case "name":
                    if (animal.getName().equalsIgnoreCase(searchValue)) {
                        animalMatches.add(animal);
                    }
                    break;
                case "species":
                    if (animal.getSpecies().equalsIgnoreCase(searchValue)) {
                        animalMatches.add(animal);
                    }
                    break;
            }
        }

        return animalMatches;
    }
}
