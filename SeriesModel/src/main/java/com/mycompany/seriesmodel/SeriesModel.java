/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seriesmodel;

/**
 *
 * @author adhir
 */
//This is the class where the app is setup
//It holds the series data
public class SeriesModel {
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;
    
    public SeriesModel() {}
        public SeriesModel(String id, String name, String age, String episodes) {
            this.SeriesId = id;
            this.SeriesName = name;
            this.SeriesAge = age;
            this.SeriesNumberOfEpisodes = episodes;
        }
        
        public int getAgeInt() {
            try { return Integer.parseInt(SeriesAge);} catch(Exception e) {return -1;}
                
            } 
        public int getEpisodesAsInt() {
            try { return Integer.parseInt(SeriesNumberOfEpisodes); }
            
        catch (Exception e) {return -1;}
}
        
        @Override
        public String toString() {
            return String.format("ID: %s | Name: %s | Age Restriction: %s | Episodes: %s", SeriesId, SeriesName, SeriesAge, SeriesNumberOfEpisodes);
        }
}
    

    

