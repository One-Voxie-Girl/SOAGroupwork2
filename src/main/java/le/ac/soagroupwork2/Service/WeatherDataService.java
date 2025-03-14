package le.ac.soagroupwork2.Service;

import le.ac.soagroupwork2.Entity.Location;
import le.ac.soagroupwork2.Entity.WeatherApiResponseEntity;
import le.ac.soagroupwork2.Entity.WeatherData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataService {
    private final RestTemplate restTemplate;

    public WeatherDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherByCity(String city) {
        String apiKey = "9852b60bd27e4e0680003159251403";
        String url = "http://api.weatherapi.com/v1/current.json?key="  + apiKey+ "&q=" + city;

        WeatherApiResponseEntity weatherInterface = restTemplate.getForObject(url, WeatherApiResponseEntity.class);

        // Convert the response to a WeatherData object
        WeatherData weatherData = new WeatherData(weatherInterface.getCurrent().getTemperature(),
                weatherInterface.getCurrent().getPrecipitation(),
                weatherInterface.getCurrent().getWindSpeed(),
                weatherInterface.getCurrent().getWeatherCondition().getText());
        return weatherData;

    }

    public Location getLocationByCity(String city) {
        String apiKey = "9852b60bd27e4e0680003159251403";
        String url = "http://api.weatherapi.com/v1/current.json?key="  + apiKey+ "&q=" + city;

        WeatherApiResponseEntity weatherInterface = restTemplate.getForObject(url, WeatherApiResponseEntity.class);
        assert weatherInterface != null;
        return weatherInterface.getLocation();

    }
}
