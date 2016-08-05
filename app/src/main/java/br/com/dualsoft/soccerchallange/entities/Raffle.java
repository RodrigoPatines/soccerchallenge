package br.com.dualsoft.soccerchallange.entities;

import com.orm.SugarRecord;

/**
 * Created by Rodrigo.Patines on 29/07/2016.
 */
public class Raffle extends SugarRecord {
    private Long id;
    private Integer national;
    private Long countryId;
    private Long associationId;
    private Long homeCoachId;
    private Long awayCoachId;

    public Raffle() { }

    public Raffle(Integer national, Long countryId, Long associationId, Long homeCoachId, Long awayCoachId) {
        this.national = national;
        this.countryId = countryId;
        this.associationId = associationId;
        this.homeCoachId = homeCoachId;
        this.awayCoachId = awayCoachId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNational() {
        return national;
    }

    public void setNational(Integer national) {
        this.national = national;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Long associationId) {
        this.associationId = associationId;
    }

    public Long getHomeCoachId() {
        return homeCoachId;
    }

    public void setHomeCoachId(Long homeCoachId) {
        this.homeCoachId = homeCoachId;
    }

    public Long getAwayCoachId() {
        return awayCoachId;
    }

    public void setAwayCoachId(Long awayCoachId) {
        this.awayCoachId = awayCoachId;
    }
}
