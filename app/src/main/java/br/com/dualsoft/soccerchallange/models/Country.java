package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Rodrigo.Patines on 04/08/2016.
 */
@IgnoreExtraProperties
public class Country {
    public String name;
    public String abbreviation;
    public Association association;

    public Country() { }

    public Country(String name, String abbreviation, Association association) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.association = association;
    }
}
