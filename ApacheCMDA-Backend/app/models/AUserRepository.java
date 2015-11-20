package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by ethan on 11/20/15.
 */
@Named
@Singleton
public interface AUserRepository extends CrudRepository<AUser, Long> {
    AUser findFirstByUserName(String name);
    AUser findByEmail(String email);
}
