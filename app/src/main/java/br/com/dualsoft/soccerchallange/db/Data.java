package br.com.dualsoft.soccerchallange.db;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.dualsoft.soccerchallange.models.Association;
import br.com.dualsoft.soccerchallange.models.Coach;
import br.com.dualsoft.soccerchallange.models.Country;
import br.com.dualsoft.soccerchallange.models.Team;

/**
 * Created by Rodrigo.Patines on 12/08/2016.
 */
public class Data {

    private static DatabaseReference db;

    public static DatabaseReference getDb() {
        if (db == null)
            db = FirebaseDatabase.getInstance().getReference();
        return db;
    }

    public static List<Association> getAssociations(DataSnapshot dataSnapshot) {
        List<Association> result = new ArrayList();
        GenericTypeIndicator<Map<String, Association>> mapType = new GenericTypeIndicator<Map<String, Association>>() { };
        Map<String, Association> map = dataSnapshot.getValue(mapType);
        for(String key: map.keySet()) {
            Association association = map.get(key);
            association.setKey(key);
            result.add(association);
        }
        return result;
    }

    public static List<Country> getCountries(DataSnapshot dataSnapshot) {
        List<Country> result = new ArrayList();
        GenericTypeIndicator<Map<String, Country>> mapType = new GenericTypeIndicator<Map<String, Country>>() { };
        Map<String, Country> map = dataSnapshot.getValue(mapType);
        for(String key: map.keySet()) {
            Country country = map.get(key);
            country.setKey(key);
            result.add(country);
        }
        return result;
    }

    public static List<Team> getTeams(DataSnapshot dataSnapshot) {
        List<Team> result = new ArrayList();
        GenericTypeIndicator<Map<String, Team>> mapType = new GenericTypeIndicator<Map<String, Team>>() { };
        Map<String, Team> map = dataSnapshot.getValue(mapType);
        for(String key: map.keySet()) {
            Team team = map.get(key);
            team.setKey(key);
            result.add(team);
        }
        return result;
    }

    public static List<Coach> getCoaches(DataSnapshot dataSnapshot) {
        List<Coach> result = new ArrayList();
        GenericTypeIndicator<Map<String, Coach>> mapType = new GenericTypeIndicator<Map<String, Coach>>() { };
        Map<String, Coach> map = dataSnapshot.getValue(mapType);
        for(String key: map.keySet()) {
            Coach coach = map.get(key);
            coach.setKey(key);
            result.add(coach);
        }
        return result;
    }
}
