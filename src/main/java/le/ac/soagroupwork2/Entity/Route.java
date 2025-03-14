package le.ac.soagroupwork2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;


public class Route {
    private String startLocation;
    private String endLocation;
    private List<String> directions;

    public Route() {
    }

    public Route(String startLocation, String endLocation, List<String> directions) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.directions = directions;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }


}
