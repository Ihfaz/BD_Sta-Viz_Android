package com.example.bdsta_viz.ui.home.listFragment;


/***********************************************************************************
 * Case Class: This class models the individual cases by district and dhaka zones. *
 *             An object of this class represents a row in the table of cases.     *
 *                                                                                 *
 * @author Ihfaz Tajwar                                                            *
 ***********************************************************************************/
public class Case {

    private String location;    // Name of location (Districts/Dhaka Zones)
    private int population;     // Population count

    // Constructors
    public Case(String location, int population) {
        this.location = location;
        this.population = population;
    }

    // Getters and Setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
