package le.ac.soagroupwork2.Entity;


public class WeatherData {
    private double temperature;
    private double precipitation;
    private double windSpeed;
    private String weatherCondition;

    public WeatherData() {
    }

    public WeatherData(double temperature, double precipitation, double windSpeed, String weatherCondition) {
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
        this.weatherCondition = weatherCondition;
    }

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

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
