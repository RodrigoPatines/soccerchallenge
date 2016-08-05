package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by Rodrigo.Patines on 04/08/2016.
 */
@IgnoreExtraProperties
public class Association {
    public String name;
    public String initials;
    public List<Country> countries;

    public Association() { }

    public Association(String name, String initials, List<Country> countries) {
        this.name = name;
        this.initials = initials;
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
