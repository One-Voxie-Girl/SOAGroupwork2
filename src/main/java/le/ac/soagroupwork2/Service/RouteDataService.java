package le.ac.soagroupwork2.Service;

import le.ac.soagroupwork2.Entity.Location;
import le.ac.soagroupwork2.Entity.Route;
import le.ac.soagroupwork2.Entity.RouteAdapter.RouteResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RouteDataService {
    private final RestTemplate restTemplate;
    private final String routeApiKey = "00b88022be094b7b968e79ec9c578fd0";



    public RouteDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Route getRoute(Location startLocation, Location endLocation) {
        String url = "https://api.geoapify.com/v1/routing?waypoints=" + startLocation.getLat() + "," + startLocation.getLon() +
                "|" + endLocation.getLat() + "," + endLocation.getLon() + "&mode=drive&apiKey=" + routeApiKey;

        RouteResponseEntity routeResponseEntity = restTemplate.getForObject(url, RouteResponseEntity.class);

        assert routeResponseEntity != null;
        List<String> steps = routeResponseEntity.getSteps();





        return new Route(startLocation.getName(), endLocation.getName(), steps);



    }





}
