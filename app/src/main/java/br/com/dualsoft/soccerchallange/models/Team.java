package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Rodrigo.Patines on 04/08/2016.
 */
@IgnoreExtraProperties
public class Team {
    public String name;
    public String abbreviation;
    public Float starRating;
    public Integer national;
    public Country country;

    public Team() { }

    public Team(String name, String abbreviation, Float starRating, Integer national, Country country) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.starRating = starRating;
        this.national = national;
        this.country = country;
    }
}
