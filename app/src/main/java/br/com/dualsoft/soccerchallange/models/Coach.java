package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rodrigo.Patines on 05/08/2016.
 */
@IgnoreExtraProperties
public class Coach {
    public String name;
    public String nickname;
    public Country country;

    public Coach() { }

    public Coach(String name, String nickname, Country country) {
        this.name = name;
        this.nickname = nickname;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("name", this.name);
        result.put("nickname", this.nickname);
        result.put("country", this.country);

        return result;
    }
}
