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
    public Long countryId;
    public Long associationId;
    public Long homeCoachId;
    public Long awayCoachId;

    public Raffle() { }

    public Raffle(Integer national, Long countryId, Long associationId, Long homeCoachId, Long awayCoachId) {
        this.national = national;
        this.countryId = countryId;
        this.associationId = associationId;
        this.homeCoachId = homeCoachId;
        this.awayCoachId = awayCoachId;
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

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("national", this.national);
        result.put("countryKey", this.countryId);
        result.put("associationId", this.associationId);
        result.put("homeCoachId", this.homeCoachId);
        result.put("awayCoachId", this.awayCoachId);

        return result;
    }
}
