package le.ac.soagroupwork2.Service;

import le.ac.soagroupwork2.Entity.Coordinate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RouteDataService {
    private final RestTemplate restTemplate;
    private final String routeApiKey = "00b88022be094b7b968e79ec9c578fd0";



    public RouteDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
//
//    public String getRoute(String startLocation, String endLocation) {
//
//        return restTemplate.getForObject(uri, String.class);
//    }
//
//    public Coordinate getCoordinateFromString(String location) {
//
//        String url = "https://api.geoapify.com/v1/geocode/search?text="+location+"&apiKey="+routeApiKey;
//
//
//    }



}
