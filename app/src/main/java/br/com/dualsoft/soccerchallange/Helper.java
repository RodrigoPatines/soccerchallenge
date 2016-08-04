package br.com.dualsoft.soccerchallange;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Date;
import java.util.Random;

/**
 * Created by Rodrigo.Patines on 29/07/2016.
 */
public class Helper {
    public static final int ACTIVITY_REQUEST_CODE = 1;

    public static void selectSpinnerItemById(Spinner spinner, long id) {
        ArrayAdapter adapter = (ArrayAdapter) spinner.getAdapter();
        for (int position = 0; position < adapter.getCount(); position++) {
            ListItem listItem =  (ListItem) adapter.getItem(position);
            if(listItem.getId() == id) {
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
