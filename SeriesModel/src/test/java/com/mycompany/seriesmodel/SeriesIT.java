/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.seriesmodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author admin
 */
public class SeriesIT {
    
    private Series series;
    
    @BeforeEach void setup() {
        series = new Series(new Scanner(System.in));
        series.addSeries(new SeriesModel("S100", "Mystery Lane", "13", "10"));
    }
    
    @Test void TestSearchSeries() {
        SeriesModel found = series.searchSeries("S100");
        assertNotNull(found, "Expected series to be found");
        assertEquals("Mystery Lane", found.SeriesName);
        assertEquals("13", found.SeriesAge);
        assertEquals("10", found.SeriesNumberOfEpisodes);
    }
    
    @Test void TestSearchSeries_SeriesNotFound() {
        SeriesModel found = series.searchSeries("NOPE");
        assertNull(found, "Expected no series to be found");
    }
    
    @Test void TestUpdateSeries() {
        boolean updated = series.updateSeriesById("S100", "Mystery Lane: Reloaded", "16", "12");
        assertTrue(updated, "Expected update to succeed");
        SeriesModel m = series.searchSeries("S100");
        assertEquals("Mystery Lane: Reloaded", m.SeriesName);
        assertEquals("16", m.SeriesAge);
        assertEquals("12", m.SeriesNumberOfEpisodes);
    }
    
    @Test void TestDeleteSeries() {
        boolean deleted = series.deleteSeriesById("S100");
        assertTrue(deleted, "Expected delete to succeed");
        
        assertNull(series.searchSeries("S100"));
    }
    
    @Test void TestDeleteSeries_SeriesNotFound(){
        boolean deleted = series.deleteSeriesById("UNKNOWN");
        assertFalse(deleted, "Expected delete to fail for unknown id");
    }
    
    @Test void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(series.isValidAgeRestriction("2"));
        assertTrue(series.isValidAgeRestriction("18"));
        assertTrue(series.isValidAgeRestriction("13"));
    }
    
    @Test void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(series.isValidAgeRestriction("1"));
        assertFalse(series.isValidAgeRestriction("19"));
        assertFalse(series.isValidAgeRestriction("abc"));
        assertFalse(series.isValidAgeRestriction(""));
        assertFalse(series.isValidAgeRestriction(null));
        
    }
    
}
