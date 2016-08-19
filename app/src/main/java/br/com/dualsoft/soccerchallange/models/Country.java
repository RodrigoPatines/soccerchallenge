package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rodrigo.Patines on 04/08/2016.
 */
@IgnoreExtraProperties
public class Country extends BaseModel {
    public String name;
    public String abbreviation;
    public Association association;
    public Map<String, Boolean> teams;
    public Map<String, Boolean> coaches;

    public Country() { }

    public Country(String name, String abbreviation) {
        this(name, abbreviation, null);
    }

    public Country(String name, String abbreviation, Association association) {
        super();
        this.name = name;
        this.abbreviation = abbreviation;
        this.association = association;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("name", this.name);
        result.put("abbreviation", this.abbreviation);
        result.put("association", this.association);
        result.put("teams", this.teams);
        result.put("coaches", this.coaches);

        return result;
    }
}
