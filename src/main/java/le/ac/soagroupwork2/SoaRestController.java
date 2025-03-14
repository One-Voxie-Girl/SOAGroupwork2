package le.ac.soagroupwork2;

import le.ac.soagroupwork2.Entity.Activity;
import le.ac.soagroupwork2.Entity.ActivitySuggestion;
import le.ac.soagroupwork2.Entity.KnowledgeBase;
import le.ac.soagroupwork2.Repo.ActivityRepo;
import le.ac.soagroupwork2.Repo.KnowledgeBaseRepo;
import le.ac.soagroupwork2.Service.RouteDataService;
import le.ac.soagroupwork2.Service.WeatherDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SoaRestController {
    private final RouteDataService routeDataService;
    private final WeatherDataService weatherDataService;
    private final ActivityRepo activityRepo;
    private final KnowledgeBaseRepo knowledgeBaseRepo;


    public SoaRestController(RouteDataService routeDataService, WeatherDataService weatherDataService, ActivityRepo activityRepo, KnowledgeBaseRepo knowledgeBaseRepo) {
        this.routeDataService = routeDataService;
        this.weatherDataService = weatherDataService;
        this.activityRepo = activityRepo;

        this.knowledgeBaseRepo = knowledgeBaseRepo;
    }


    @PostMapping("/activity")
    public ResponseEntity<String> createActivity(@RequestBody Activity activity) {



        activityRepo.save(activity);

        return ResponseEntity.ok("Activity created");

    }



    @GetMapping("/activitysuggestion")
    public ResponseEntity<ActivitySuggestion> getActivitySuggestion(@RequestParam String location) {
        System.out.println(location);

        ActivitySuggestion activitySuggestion = new ActivitySuggestion();


        activitySuggestion.setWeatherData(weatherDataService.getWeatherByCity(location));
        KnowledgeBase kb = knowledgeBaseRepo.findKnowledgeBaseByWeatherCondition(activitySuggestion.getWeatherData().getWeatherCondition());
        if (kb!=null&&kb.getActivities()!=null) {
            activitySuggestion.setActivity(kb.getActivities().get(0));

        }
//        List<Activity> activities = knowledgeBaseRepo.findActivitiesByWeatherCondition(activitySuggestion.getWeatherData().getWeatherCondition());

        return ResponseEntity.ok(activitySuggestion);

    }

}
