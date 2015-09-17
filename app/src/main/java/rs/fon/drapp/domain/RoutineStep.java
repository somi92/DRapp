package rs.fon.drapp.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by milos on 9/17/15.
 */
public class RoutineStep implements Serializable {

    @SerializedName("stepNumber")
    private int stepNumber;
    @SerializedName("description")
    private String description;
    @SerializedName("imageResource")
    private String imageResource;
    @SerializedName("audioResource")
    private String audioResource;

    public RoutineStep() {
    }

    public RoutineStep(int stepNumber, String description, String imageResource, String audioResource) {
        this.stepNumber = stepNumber;
        this.description = description;
        this.imageResource = imageResource;
        this.audioResource = audioResource;
    }


    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.stepNumber;
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
        final RoutineStep other = (RoutineStep) obj;
        if (this.stepNumber != other.stepNumber) {
            return false;
        }
        return true;
    }
}
