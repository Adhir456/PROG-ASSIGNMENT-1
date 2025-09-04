/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesmodel;
import java.util.Scanner;

/*

        
 */       

/**
 *
 * @author adhir
 */
//This is the class where the application starts and runs
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Series series = new Series(scanner);
        //Menu display 
        boolean running = true;
        while (running) {
            System.out.println();
            
            System.out.println("****************************************************************************");
            System.out.println("LATEST SERIES - 2025");
             System.out.println("****************************************************************************");
             System.out.println("Please select one of the following menu items:");
             System.out.println("(1) Capture a new series.");
             System.out.println("(2) Search for a series.");
             System.out.println("(3) Update series age restriction");
             System.out.println("(4) Delete a Series.");
             System.out.println("(5) Print series report - 2025");
             System.out.println("(6) Exit Application.");
             
             String choice = scanner.nextLine().trim();
             System.out.println();
             
             switch (choice) {
                 case "1" :  series.CaptureSeries();
                 pause(scanner);
                 break;
                 case "2" :  series.SearchSeries();
                 pause(scanner);
                 break;
                 case "3" : series.UpdateSeries();
                 pause(scanner);
                 break;
                 case "4" : series.DeleteSeries();
                 pause(scanner);
                 break;
                 case "5" : series.SeriesReport();
                 pause(scanner);
                 break;
                 case "6" : { series.ExitSeriesApplication(); running = false; }
                 break;
                 
                 default:
             System.out.println("Invalid option. Please choose 1-6");
                 
             pause(scanner);
                 break;
             }
        }
    
    
    }
    
    private static void pause(Scanner scanner) {
        System.out.print("\nPress ENTER to return to the menu...");
        scanner.nextLine();
    }
}
