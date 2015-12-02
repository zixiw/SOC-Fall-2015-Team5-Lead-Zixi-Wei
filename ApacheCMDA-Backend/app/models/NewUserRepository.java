package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by zixiwei on 11/30/15.
 */
@Named
@Singleton
public interface NewUserRepository extends CrudRepository<NewUser, Long> {
    NewUser findFirstByUserName(String userName);
    NewUser findFirstByEmail(String email);
}
