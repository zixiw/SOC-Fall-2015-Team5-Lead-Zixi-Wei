package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by mingyangling on 11/18/15.
 */
@Named
@Singleton
public interface BtestRepository extends CrudRepository<Btest, Long> {
    Btest findFirstByName(String name);
    List<Btest> findByAtest(Atest atest);

}
