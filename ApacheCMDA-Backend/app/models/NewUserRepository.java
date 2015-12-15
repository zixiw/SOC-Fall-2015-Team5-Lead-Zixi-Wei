package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/30/15.
 */
@Named
@Singleton
public interface NewUserRepository extends CrudRepository<NewUser, Long> {
    NewUser findFirstByUserName(String userName);
    NewUser findFirstByEmail(String email);
}
