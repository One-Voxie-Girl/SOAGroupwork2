package le.ac.soagroupwork2.Repo;

import le.ac.soagroupwork2.Entity.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepo extends CrudRepository<Activity, Integer> {
    public List<Activity> findAll();

    public void deleteById(Integer id);


}
