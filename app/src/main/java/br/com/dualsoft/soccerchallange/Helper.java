package br.com.dualsoft.soccerchallange;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;

import java.util.Date;
import java.util.Random;

/**
 * Created by Rodrigo.Patines on 29/07/2016.
 */
public class Helper {
    public static final int ACTIVITY_REQUEST_CODE = 1;

    public static void selectSpinnerItemById(Spinner spinner, String key) {
        ArrayAdapter adapter = (ArrayAdapter) spinner.getAdapter();
        for (int position = 0; position < adapter.getCount(); position++) {
            ListItem listItem =  (ListItem) adapter.getItem(position);
            if(listItem.getKey() == key) {
                spinner.setSelection(position);
                return;
            }
        }
    }
    public static Date now() {
        return new Date(System.currentTimeMillis());
    }

    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
