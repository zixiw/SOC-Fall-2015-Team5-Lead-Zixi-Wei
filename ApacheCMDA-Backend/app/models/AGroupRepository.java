package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by ethan on 11/20/15.
 */
@Named
@Singleton
public interface AGroupRepository extends CrudRepository<AGroup, Long> {
    AGroup findFirstByName(String name);
}
