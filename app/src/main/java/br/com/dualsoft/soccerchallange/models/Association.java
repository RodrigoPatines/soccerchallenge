package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rodrigo.Patines on 04/08/2016.
 */
@IgnoreExtraProperties
public class Association extends BaseModel {
    public String name;
    public String initials;
    public Map<String, Country> countries;

    public Association() { }

    public Association(String name, String initials) {
        super();
        this.name = name;
        this.initials = initials;
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

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("name", this.name);
        result.put("initials", this.initials);
        result.put("countries", this.countries);

        return result;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
