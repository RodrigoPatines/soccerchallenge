package br.com.dualsoft.soccerchallange.entities;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

import br.com.dualsoft.soccerchallange.Helper;

/**
 * Created by Rodrigo.Patines on 25/07/2016.
 */
public class Coach extends SugarRecord implements Serializable {
    private Long id;
    private String name;
    private String nickname;
    private Country country;
    private Date modificationDate;
    private int sync;

    public Coach() {
        this.modificationDate = Helper.now();
        this.sync = 1;
    }

    public Coach(String name, String nickname, Country country) {
        this.name = name;
        this.nickname = nickname;
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
