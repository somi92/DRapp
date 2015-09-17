package rs.fon.drapp.json;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import rs.fon.drapp.domain.RoutinesCollection;

/**
 * Created by milos on 9/17/15.
 */
public class RoutinesManager {

    private static RoutinesManager INSTANCE;

    private RoutinesManager() {

    }

    public static RoutinesManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RoutinesManager();
        }
        return INSTANCE;
    }

    public RoutinesCollection loadRoutines(Context context, String jsonFilePath) {
        String json = null;
        InputStream is = null;
        try {
            is = context.getAssets().open(jsonFilePath);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            RoutinesCollection rc = gson.fromJson(json, RoutinesCollection.class);
            return rc;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
