package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.*;
import java.util.List;

/**
 * Created by mingyangling on 11/18/15.
 */
@Named
@Singleton
public interface AtestRepository extends CrudRepository<Atest, Long> {
    Atest findFirstByName(String name);

}
