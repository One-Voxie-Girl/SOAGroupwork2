package le.ac.soagroupwork2.Entity;

import jakarta.persistence.*;

@Entity
public class Activity {
    @Id
    private String activityName;
    private String type;
    private String location;
    private String activityDescription;


    public Activity() {
    }

    public Activity(String activityName, String type, String location, String activityDescription) {
        this.activityName = activityName;
        this.type = type;
        this.location = location;
        this.activityDescription = activityDescription;
    }



    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }


}
