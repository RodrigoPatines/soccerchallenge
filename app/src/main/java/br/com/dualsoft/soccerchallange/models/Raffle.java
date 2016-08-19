package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rodrigo.Patines on 05/08/2016.
 */
@IgnoreExtraProperties
public class Raffle {
    public Integer national;
    public Country country;
    public Association association;
    public Coach homeCoach;
    public Coach awayCoach;

    public Raffle() {
        this.national = 0;
        this.country = new Country();
        this.association = new Association();
        this.homeCoach = new Coach();
        this.awayCoach = new Coach();
    }

    public Raffle(Integer national, Country country, Association association, Coach homeCoach, Coach awayCoach) {
        this.national = national;
        this.country = country;
        this.association = association;
        this.homeCoach = homeCoach;
        this.awayCoach = awayCoach;
    }

    public Integer getNational() {
        return national;
    }

    public void setNational(Integer national) {
        this.national = national;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Coach getHomeCoach() {
        return homeCoach;
    }

    public void setHomeCoach(Coach homeCoach) {
        this.homeCoach = homeCoach;
    }

    public Coach getAwayCoach() {
        return awayCoach;
    }

    public void setAwayCoach(Coach awayCoach) {
        this.awayCoach = awayCoach;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("national", this.national);
        result.put("country", this.country);
        result.put("association", this.association);
        result.put("homeCoach", this.homeCoach);
        result.put("awayCoach", this.awayCoach);

        return result;
    }
}
