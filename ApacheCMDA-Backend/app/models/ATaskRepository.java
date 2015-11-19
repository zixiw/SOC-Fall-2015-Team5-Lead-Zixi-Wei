package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by mingyangling on 11/16/15.
 */
@Named
@Singleton
public interface ATaskRepository extends CrudRepository<ATask, Long> {
    ATask findFirstByName(String name);
}
