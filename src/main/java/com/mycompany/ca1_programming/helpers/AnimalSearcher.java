/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca1_programming.helpers;

import com.mycompany.ca1_programming.models.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pavel
 */
public class AnimalSearcher {
    public static List<Animal> searchAnimals(List<Animal> animals, String searchKey, String searchValue) {
        List<Animal> matchedAnimals = new ArrayList<>();

        // Loop over each animal to find if it matches the search query
        for (Animal animal : animals) {
            // Use switch to iterate between allowed search keys
            switch (searchKey.toLowerCase()) {
                case "type":
                    // If animal's type matches the search value add it to the matches list
                    if (animal.getClass().getSimpleName().equalsIgnoreCase(searchValue)) {
                        matchedAnimals.add(animal);
                    }
                    break;
                case "habitat":
                    // Same as the previous step but for a different Animal property
                    if (animal.getHabitat().equalsIgnoreCase(searchValue)) {
                        matchedAnimals.add(animal);
                    }
                    break;
                case "name":
                    if (animal.getName().equalsIgnoreCase(searchValue)) {
                        matchedAnimals.add(animal);
                    }
                    break;
                case "species":
                    if (animal.getSpecies().equalsIgnoreCase(searchValue)) {
                        matchedAnimals.add(animal);
                    }
                    break;
            }
        }

        return matchedAnimals;
    }
}
