package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rodrigo.Patines on 05/08/2016.
 */
@IgnoreExtraProperties
public class Coach extends BaseModel {
    public String name;
    public String nickname;
    public String countryKey;
    public Country country;

    public Coach() { }

    public Coach(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public Coach(String name, String nickname, String countryKey) {
        this(name, nickname);
        this.countryKey = countryKey;
    }

    public Coach(String name, String nickname, Country country) {
        this(name, nickname);
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

    public String getCountryKey() {
        return countryKey;
    }

    public void setCountryKey(String countryKey) {
        this.countryKey = countryKey;
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
        result.put("countryKey", this.countryKey);
        result.put("country", this.country);

        return result;
    }
}
