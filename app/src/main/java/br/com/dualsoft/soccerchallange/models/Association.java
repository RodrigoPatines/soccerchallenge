package br.com.dualsoft.soccerchallange.models;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.dualsoft.soccerchallange.Helper;

/**
 * Created by Rodrigo.Patines on 24/07/2016.
 */
public class Association extends SugarRecord implements Serializable {
    private Long id;
    private String name;
    private String initials;
    private Date modificationDate;
    private int sync;

    public Association() {
        this.modificationDate = Helper.now();
        this.sync = 1;
    }

    public Association(String name, String initials) {
        this.name = name;
        this.initials = initials;
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

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
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

    public List<Country> getCountries() {
        return Country.find(Country.class, "association = ?", new String[]{ this.getId().toString()});
    }
}
