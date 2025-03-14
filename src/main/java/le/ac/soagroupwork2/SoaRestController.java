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


    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> getActivities() {
        return ResponseEntity.ok(activityRepo.findAll());
    }

    @GetMapping("/activity")
    public ResponseEntity<Activity> getActivity(@RequestParam String activityName) {
        return ResponseEntity.ok(activityRepo.findActivityByActivityName(activityName));
    }

    @PostMapping("/activity")
    public ResponseEntity<String> createActivity(@RequestBody Activity activity, @RequestParam String weatherCondition) {
        KnowledgeBase knowledgeBase = knowledgeBaseRepo.findKnowledgeBaseByWeatherCondition(weatherCondition);
        if (knowledgeBase == null) {
            return ResponseEntity.badRequest().body("Weather condition not found");
        } else {
            knowledgeBase.getActivities().add(activity);
            knowledgeBaseRepo.save(knowledgeBase);
        }

        return ResponseEntity.ok("Activity created");

    }

    @PutMapping("/activity")
    public ResponseEntity<String> updateActivity(@RequestBody Activity activity) {
        activityRepo.save(activity);
        return ResponseEntity.ok("Activity updated");
    }

    @DeleteMapping("/activity")
    public ResponseEntity<String> deleteActivity(@RequestParam String activityName) {
        activityRepo.deleteById(activityName);
        return ResponseEntity.ok("Activity deleted");
    }


    @GetMapping("/knowledgebases")
    public ResponseEntity<List<KnowledgeBase>> getKnowledgeBases() {
        return ResponseEntity.ok(knowledgeBaseRepo.findAll());
    }

    @GetMapping("/knowledgebase")
    public ResponseEntity<KnowledgeBase> getKnowledgeBase(@RequestParam String weatherCondition) {
        return ResponseEntity.ok(knowledgeBaseRepo.findKnowledgeBaseByWeatherCondition(weatherCondition));
    }

    @PostMapping("/knowledgebase")
    public ResponseEntity<String> createKnowledgeBase(@RequestBody KnowledgeBase knowledgeBase) {
        knowledgeBaseRepo.save(knowledgeBase);
        return ResponseEntity.ok("Knowledge base created");
    }

    @PutMapping("/knowledgebase")
    public ResponseEntity<String> updateKnowledgeBase(@RequestBody KnowledgeBase knowledgeBase) {
        knowledgeBaseRepo.save(knowledgeBase);
        return ResponseEntity.ok("Knowledge base updated");
    }

    @DeleteMapping("/knowledgebase")
    public ResponseEntity<String> deleteKnowledgeBase(@RequestParam String weatherCondition) {
        knowledgeBaseRepo.deleteById(weatherCondition);
        return ResponseEntity.ok("Knowledge base deleted");
    }









    @GetMapping("/activitysuggestion")
    public ResponseEntity<ActivitySuggestion> getActivitySuggestion(@RequestParam String location) {


        ActivitySuggestion activitySuggestion = new ActivitySuggestion();


        activitySuggestion.setWeatherData(weatherDataService.getWeatherByCity(location));
        KnowledgeBase kb = knowledgeBaseRepo.findKnowledgeBaseByWeatherCondition(activitySuggestion.getWeatherData().getWeatherCondition());
        if (kb!=null&&kb.getActivities()!=null) {
            activitySuggestion.setActivity(kb.getActivities().get(0));

        }


        activitySuggestion.setRouteData(routeDataService.getRoute(weatherDataService.getLocationByCity(location),
                weatherDataService.getLocationByCity(activitySuggestion.getActivity().getLocation())));

        activitySuggestion.setSuggestionMessage("The weather is " + activitySuggestion.getWeatherData().getWeatherCondition() + " in " + location + ". You can go to " + activitySuggestion.getActivity().getActivityName() + " in " + activitySuggestion.getActivity().getLocation() + " to enjoy the weather.");



        return ResponseEntity.ok(activitySuggestion);

    }

}
