/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesmodel;
import java.util.*;

/**
 *
 * @author adhir
 */
//This class holds the method to the application
// The class manages the ArrayList
public class Series {
    private final List<SeriesModel>
            seriesList = new ArrayList<>();
    private final Scanner scanner;
    
    public Series(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public boolean addSeries(SeriesModel model) {
        if (model == null || model.SeriesId == null || model.SeriesId.isBlank())return false;
         if (searchSeries(model.SeriesId) != null) return false;
         if (! 
                 isValidAgeRestriction(model.SeriesAge))
             return false;
         if (!
                 isNumeric(model.SeriesNumberOfEpisodes))
                 return false;
         seriesList.add(model);
         return true;
         }
    
    public SeriesModel searchSeries (String id) {
        for (SeriesModel m : seriesList) {
            if (m.SeriesId.equalsIgnoreCase(id)) return m;
        }
        return null;
    }
    
    public boolean updateSeriesById(String id, String newName, String newAge , String newEpisodes) {
        SeriesModel m = searchSeries(id);
        if (m== null) return false;
        if (newName != null && ! newName.isBlank()) m.SeriesName = newName;
        if (newAge != null && ! newAge.isBlank()) {
            if (! isValidAgeRestriction(newAge)) return false;
            m.SeriesAge = newAge;
        }
        if (newEpisodes != null && ! newEpisodes.isBlank()) {
        if (!isNumeric(newEpisodes))
            return false;
        m.SeriesNumberOfEpisodes = newEpisodes;
    }
        return true;
    }
    
    public boolean deleteSeriesById(String id) {
        SeriesModel m = searchSeries(id);
        if (m == null) return false;
        return seriesList.remove(m);
    }
    public boolean isValidAgeRestriction(String ageStr) { //Age Validation
        if (!isNumeric(ageStr)) return false;
        int age = Integer.parseInt(ageStr);
        return age >= 2 && age <= 18;
    }
    private boolean isNumeric(String s) {
        if (s == null) return false;
        try { Integer.parseInt(s); return true;} catch (Exception e) {
            return false;}
        
    }
    public List<SeriesModel> getAll() {
        return
                Collections.unmodifiableList(seriesList);
    }
    public void CaptureSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("**********************************");
        System.out.print("SERIES ID:");
        String id = scanner.nextLine().trim();
        if (searchSeries(id) != null ) {
            System.out.println("A series with this ID already exists. Capture cancelled.");
            return;
        }
        System.out.print("SERIES NAME: ");
        String name = scanner.nextLine().trim();
        
        String age;
        while (true) {
            System.out.print("SERIES AGE RESTRICTION(2-18): ");
            age = scanner.nextLine().trim();
            if (!isNumeric(age)) {
                System.out.println("You have entered an incorrect series age!!!");
                continue;
            }
            if (! isValidAgeRestriction(age)) {
                System.out.println("Invalid age restriction. Must be between 2 and 18");
                continue;
            }
            break;
        }
        String episodes;
        while (true) {
            System.out.print("SERIES NUMBER OF EPISODES: ");
            episodes = scanner.nextLine().trim();
            if (!isNumeric(episodes)) {
                System.out.println("Invalid input. Episodes must be a number.");
                continue;
            }
            break;
        }
        SeriesModel model = new SeriesModel(id, name, age, episodes);
        seriesList.add(model);
        System.out.println("Series saved successfully!");
    }
    
    public void SearchSeries() {
        System.out.println("=== Search Series ===");
        System.out.print("Enter Series ID to search: ");
        String id = scanner.nextLine().trim();
        SeriesModel m = searchSeries(id);
        if (m == null) {
            System.out.println("No series data could be found for ID: " + id);
        } else {
            System.out.println("Series found:");
            System.out.println(m);
        }
    }
    
    public void UpdateSeries() {
        System.out.println("=== Update Series ===");
        System.out.print("Enter Series ID to update: ");
        String id = scanner.nextLine().trim();
        SeriesModel m = searchSeries(id);
        if (m == null) {
            System.out.println("No series found for ID: " + id);
            return;
        }
        System.out.println("Leave a field blank to keep current value");
        System.out.printf("Current Name: %s | Enter New Name ", m.SeriesName);
        String newName = scanner.nextLine().trim();
        if (!newName.isBlank()) m.SeriesName = newName;
        
        while (true) {
            System.out.printf("Current Age: %s | Enter New Age (2-18): ", m.SeriesAge);
            String newAge = scanner.nextLine().trim();
            if (newAge.isBlank()) break;
            if (!isNumeric(newAge)) {
                System.out.println("Invalid input. Age must be a number.");
                continue;
            }
            m.SeriesAge = newAge;
            break;
        }
        while (true) {
            System.out.printf("Current Episodes: %s | Enter New Episodes: ", m.SeriesNumberOfEpisodes);
            String newEpisodes = scanner.nextLine().trim();
            if (newEpisodes.isBlank())
                break;
            if (!isNumeric(newEpisodes)) {
                System.out.println("Invalid input, Episodes must be a number.");
                continue;
            }
            m.SeriesNumberOfEpisodes = newEpisodes;
            break;
        }
        System.out.println("Series updated successfully!");
    }
    public void DeleteSeries() {
        System.out.println("=== Delete Series ===");
        System.out.print("Enter Series ID to delete: ");
        String id = scanner.nextLine().trim();
        SeriesModel m = searchSeries(id);
        if (m == null) {
            System.out.println("No series found for ID: " + id);
            return;
        }
        System.out.println("Series to delete: " + m);
        System.out.print("Are you sure you want to delete? (Y/N): ");
        String confirm = scanner.nextLine().trim();
        if (confirm.equalsIgnoreCase("Y")) {
            seriesList.remove(m);
            System.out.println("Series deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }
    public void SeriesReport() {
        System.out.println("=== Series Report===");
        if (seriesList.isEmpty()) {
            System.out.println("No series captured.");
            return;
        }
        System.out.printf("%-10s | %-25s | %-3s | %-8s%n", "SeriesID", "SeriesName", "Age Restriction ", "Episodes");
        System.out.println("----------------------------------------------------------------------------------------");
        for (SeriesModel m : seriesList) {
            System.out.printf("%-10s | %-25s | %-3s              | %-8s%n", m.SeriesId, m.SeriesName, m.SeriesAge, m.SeriesNumberOfEpisodes);
        }
    }
    
    public void ExitSeriesApplication() {
        System.out.println("Goodbye!");
    }
}
