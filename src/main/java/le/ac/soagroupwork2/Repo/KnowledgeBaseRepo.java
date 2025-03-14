package le.ac.soagroupwork2.Repo;

import le.ac.soagroupwork2.Entity.Activity;
import le.ac.soagroupwork2.Entity.KnowledgeBase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeBaseRepo extends CrudRepository<KnowledgeBase, String> {
    public List<KnowledgeBase> findAll();
    public void deleteById(String weatherCondition);

    public List<Activity> findActivitiesByWeatherCondition(String weatherCondition);


    KnowledgeBase findKnowledgeBaseByWeatherCondition(String weatherCondition);
}
