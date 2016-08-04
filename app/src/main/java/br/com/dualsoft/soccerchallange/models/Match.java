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
public class Match extends SugarRecord implements Serializable {
    private Long id;
    private Date date;
    private Team homeTeam;
    private Team awayTeam;
    private Coach homeCoach;
    private Coach awayCoach;
    private Integer homeScore;
    private Integer awayScore;
    private Integer homePenaltyScore;
    private Integer awayPenaltyScore;
    private Date modificationDate;
    private int sync;

    public Match() {
        this.modificationDate = Helper.now();
        this.sync = 1;
    }

    public Match(Date date, Team homeTeam, Team awayTeam, Coach homeCoach, Coach awayCoach, Integer homeScore, Integer awayScore, Integer homePenaltyScore, Integer awayPenaltyScore) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeCoach = homeCoach;
        this.awayCoach = awayCoach;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homePenaltyScore = homePenaltyScore;
        this.awayPenaltyScore = awayPenaltyScore;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Coach getHomeCoach() {
        return homeCoach;
    }

    public void setHomeCoach(Coach homeCoach) {
        this.homeCoach = homeCoach;
    }

    public Coach getAwayCoach() {
        return awayCoach;
    }

    public void setAwayCoach(Coach awayCoach) {
        this.awayCoach = awayCoach;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public Integer getHomePenaltyScore() {
        return homePenaltyScore;
    }

    public void setHomePenaltyScore(Integer homePenaltyScore) {
        this.homePenaltyScore = homePenaltyScore;
    }

    public Integer getAwayPenaltyScore() {
        return awayPenaltyScore;
    }

    public void setAwayPenaltyScore(Integer awayPenaltyScore) {
        this.awayPenaltyScore = awayPenaltyScore;
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
