package br.com.dualsoft.soccerchallange.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

import br.com.dualsoft.soccerchallange.Helper;

/**
 * Created by Rodrigo.Patines on 25/07/2016.
 */
public class Team extends SugarRecord implements Serializable {
    private Long id;
    private String name;
    private String abbreviation;
    private Float starRating;
    private Integer national;
    private Country country;
    private Date modificationDate;
    private int sync;

    public Team() {
        this.modificationDate = Helper.now();
        this.sync = 1;
    }

    public Team(String name, String abbreviation, Float starRating, Integer national, Country country) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.starRating = starRating;
        this.national = national;
        this.country = country;
        this.modificationDate = Helper.now();
        this.sync = 1;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public int getSync() {
        return sync;
    }

    public void setSync(int sync) {
        this.sync = sync;
    }
}
