package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rodrigo.Patines on 04/08/2016.
 */
@IgnoreExtraProperties
public class Team extends BaseModel {
    public String name;
    public String abbreviation;
    public Float starRating;
    public Integer national;
    public String countryId;

    public Team() { }

    public Team(String name, String abbreviation, Float starRating, Integer national, String countryId) {
        super();
        this.name = name;
        this.abbreviation = abbreviation;
        this.starRating = starRating;
        this.national = national;
        this.countryId = countryId;
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

    public Float getStarRating() {
        return starRating;
    }

    public void setStarRating(Float starRating) {
        this.starRating = starRating;
    }

    public Integer getNational() {
        return national;
    }

    public void setNational(Integer national) {
        this.national = national;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("name", this.name);
        result.put("abbreviation", this.abbreviation);
        result.put("starRating", this.starRating);
        result.put("national", this.national);
        result.put("countryId", this.countryId);

        return result;
    }
}
