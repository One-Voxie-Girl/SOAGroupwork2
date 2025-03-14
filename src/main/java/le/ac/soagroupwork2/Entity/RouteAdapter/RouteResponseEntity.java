package le.ac.soagroupwork2.Entity.RouteAdapter;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteResponseEntity {
    @JsonProperty("features")
    private List<Features> features;

    public List<Features> getFeatures() {
        return features;
    }

    public void setFeatures(List<Features> features) {
        this.features = features;
    }

    public List<String> getSteps() {
        List<String> steps = new ArrayList<>();
        List<Step> stepList = this.features.get(0).getProperties().getLegs().get(0).getSteps();
        for (int i = 0; i < stepList.size(); i++) {
            steps.add(stepList.get(i).getInstruction().getText());
        }
        return steps;
    }
}
