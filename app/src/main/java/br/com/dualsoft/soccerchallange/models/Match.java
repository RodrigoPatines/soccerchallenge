package br.com.dualsoft.soccerchallange.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rodrigo.Patines on 05/08/2016.
 */
@IgnoreExtraProperties
public class Match extends BaseModel {
    public Date date;
    public Team homeTeam;
    public Team awayTeam;
    public Coach homeCoach;
    public Coach awayCoach;
    public Integer homeScore;
    public Integer awayScore;
    public Integer homePenaltyScore;
    public Integer awayPenaltyScore;

    public Match() { }

    public Match(Date date, Team homeTeam, Team awayTeam, Coach homeCoach, Coach awayCoach, Integer homeScore, Integer awayScore, Integer homePenaltyScore, Integer awayPenaltyScore) {
        super();
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeCoach = homeCoach;
        this.awayCoach = awayCoach;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homePenaltyScore = homePenaltyScore;
        this.awayPenaltyScore = awayPenaltyScore;
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


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("date", this.date);
        result.put("homeTeam", this.homeTeam);
        result.put("awayTeam", this.awayTeam);
        result.put("homeCoach", this.homeCoach);
        result.put("awayCoach", this.awayCoach);
        result.put("homeScore", this.homeScore);
        result.put("awayScore", this.awayScore);
        result.put("homePenaltyScore", this.homePenaltyScore);
        result.put("homePenaltyScore", this.homePenaltyScore);

        return result;
    }
}
