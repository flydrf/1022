package com.example.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private CountryDB db;

    public Game(){
        this.db = new CountryDB();
    }

    public String qa(){
        List<String> capitals = this.db.getCapitals();
        int n = capitals.size();
        int index = (int)(n * Math.random());
        String c = capitals.get(index);
        Map<String, Country> countryData = this.db.getData();
        Country ref = countryData.get(c);

        if(Math.random() < 0.5){
            return "What is the capital of " + ref.getName() + "?\n" + ref.getCapital();
        }
        else{
            return ref.getCapital() + " is the capital of?\n" + ref.getName();
        }
    }
}
