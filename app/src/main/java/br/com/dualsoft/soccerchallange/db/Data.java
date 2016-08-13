package br.com.dualsoft.soccerchallange.db;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.dualsoft.soccerchallange.models.Association;

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
}
