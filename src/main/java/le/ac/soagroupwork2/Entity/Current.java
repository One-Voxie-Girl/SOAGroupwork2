package le.ac.soagroupwork2.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    @JsonProperty("temp_c")
    private double temperature;
    @JsonProperty("precip_mm")
    private double precipitation;
    @JsonProperty("wind_kph")
    private double windSpeed;
    @JsonProperty("condition")
    private WCondition weatherCondition;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public WCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
