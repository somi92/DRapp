package rs.fon.drapp.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Created by milos on 9/17/15.
 */
public class Routine implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("imageResource")
    private String imageResource;
    @SerializedName("audioResource")
    private String audioResource;
    @SerializedName("steps")
    private List<RoutineStep> steps;

    public Routine() {
        steps = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public String getAudioResource() {
        return audioResource;
    }

    public void setAudioResource(String audioResource) {
        this.audioResource = audioResource;
    }

    public List<RoutineStep> getSteps() {
        sortSteps();
        return steps;
    }

    public void setSteps(List<RoutineStep> steps) {
        this.steps = steps;
        sortSteps();
    }

    public boolean addStep(RoutineStep step) {
        if(steps.contains(step)) {
            return false;
        }
        steps.add(step);
//        step.setParentRoutine(this);
        return true;
    }

    public void editStep(RoutineStep step) {
        if(steps.contains(step)) {
            steps.remove(step);
        }
        steps.add(step);
    }

    public boolean removeStep(RoutineStep step) {
        return steps.remove(step);
    }

    private void sortSteps() {
        Collections.sort(steps, new Comparator<RoutineStep>() {

            @Override
            public int compare(RoutineStep o1, RoutineStep o2) {
                if (o1.getStepNumber() < o2.getStepNumber())
                    return -1;
                if (o1.getStepNumber() > o2.getStepNumber())
                    return 1;
                return 0;
            }

        });
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Routine other = (Routine) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
