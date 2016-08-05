package br.com.dualsoft.soccerchallange.entities;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.dualsoft.soccerchallange.Helper;

/**
 * Created by Rodrigo.Patines on 24/07/2016.
 */
public class Country extends SugarRecord implements Serializable {
    private Long id;
    private String name;
    private String abbreviation;
    private Association association;
    private Date modificationDate;
    private int sync;

    public Country() {
        this.modificationDate = Helper.now();
        this.sync = 1;
    }

    public Country(String name, String abbreviation, Association association) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.association = association;
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

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
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

    public List<Team> getTeams() {
        return Team.find(Team.class, "country = ?", new String[]{ this.getId().toString()});
    }

    public List<Coach> getCoaches() {
        return Coach.find(Coach.class, "country = ?", new String[]{ this.getId().toString()});
    }
}
