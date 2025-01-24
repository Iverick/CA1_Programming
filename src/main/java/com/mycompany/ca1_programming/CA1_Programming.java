/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ca1_programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;

/**
 *
 * @author User
 */
public class CA1_Programming {

    public static void main(String[] args) {
        String inputFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "animals.txt").toAbsolutePath().toString();
        System.out.println(inputFilePath);
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] speciesNameLine = line.split(",");

                String species = speciesNameLine[0];
                String name = speciesNameLine[1];
                String habitat = bufferedReader.readLine();
                
                String[] dobWeightLine = bufferedReader.readLine().split(",");
                String dob = dobWeightLine[0];
                String weight = dobWeightLine[1];
                
                String[] typeLine = bufferedReader.readLine().split(",");
                String type = typeLine[0];
                System.out.println(type);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
