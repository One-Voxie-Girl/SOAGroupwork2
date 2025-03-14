package le.ac.soagroupwork2.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class KnowledgeBase {
    @Id
    private String weatherCondition;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn
    private List<Activity> activities;


    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
