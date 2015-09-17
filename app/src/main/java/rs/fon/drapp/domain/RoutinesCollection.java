package rs.fon.drapp.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by milos on 9/17/15.
 */
public class RoutinesCollection implements Serializable {

    @SerializedName("routines")
    private List<Routine> routines;

    public RoutinesCollection(List<Routine> routines) {
        this.routines = routines;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }
}
