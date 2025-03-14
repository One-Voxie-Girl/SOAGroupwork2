package le.ac.soagroupwork2.Entity;

public class ActivitySuggestion {
    private String suggestionMessage;
    private WeatherData weatherData;
    private Activity activity;
    private Route routeData;

    public ActivitySuggestion() {
    }

    public ActivitySuggestion(String suggestionMessage, WeatherData weatherData, Activity activity, Route routeData) {
        this.suggestionMessage = suggestionMessage;
        this.weatherData = weatherData;
        this.activity = activity;
        this.routeData = routeData;
    }

    public String getSuggestionMessage() {
        return suggestionMessage;
    }

    public void setSuggestionMessage(String suggestionMessage) {
        this.suggestionMessage = suggestionMessage;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Route getRouteData() {
        return routeData;
    }

    public void setRouteData(Route routeData) {
        this.routeData = routeData;
    }
}
