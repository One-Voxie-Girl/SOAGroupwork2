package le.ac.soagroupwork2;

import le.ac.soagroupwork2.Entity.Activity;
import le.ac.soagroupwork2.Entity.KnowledgeBase;
import le.ac.soagroupwork2.Repo.KnowledgeBaseRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoaGroupwork2Application implements ApplicationRunner {

    private final KnowledgeBaseRepo knowledgeBaseRepo;

    public SoaGroupwork2Application(KnowledgeBaseRepo knowledgeBaseRepo) {
        this.knowledgeBaseRepo = knowledgeBaseRepo;
    }


    public static void main(String[] args) {
        SpringApplication.run(SoaGroupwork2Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        knowledgeBaseRepo.deleteAll();
        KnowledgeBase knowledgeBase = new KnowledgeBase();
        knowledgeBase.setWeatherCondition("Clear");
        Activity activity = new Activity("Mountain Hiking","Outdoor","Lancaster",
                "A scenic trail with beautiful views and wildlife");
        knowledgeBase.setActivities(new java.util.ArrayList<>());
        knowledgeBase.getActivities().add(activity);

        knowledgeBaseRepo.save(knowledgeBase);
        knowledgeBase.setWeatherCondition("Partly Cloudy");
        activity = new Activity("Kayaking","Outdoor","London",
                "Paddle across a peaceful lake and enjoy nature");
        knowledgeBase.setActivities(new java.util.ArrayList<>());
        knowledgeBase.getActivities().add(activity);
        knowledgeBaseRepo.save(knowledgeBase);
        knowledgeBase.setWeatherCondition("Cloudy");
        activity = new Activity("Cycling","Outdoor","Liverpool",
                "Ride through the city and explore the sights");
        knowledgeBase.setActivities(new java.util.ArrayList<>());
        knowledgeBase.getActivities().add(activity);
        knowledgeBaseRepo.save(knowledgeBase);
        knowledgeBase.setWeatherCondition("Moderate Rain");
        activity = new Activity("Indoor Rock Climbing","Indoor","Manchester",
                "Climb a variety of walls and routes");
        knowledgeBase.setActivities(new java.util.ArrayList<>());
        knowledgeBase.getActivities().add(activity);






        knowledgeBaseRepo.save(knowledgeBase);










    }


}
