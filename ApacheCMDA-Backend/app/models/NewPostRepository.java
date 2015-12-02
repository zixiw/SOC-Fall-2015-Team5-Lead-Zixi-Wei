package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by zixiwei on 11/30/15.
 */
@Named
@Singleton
public interface NewPostRepository extends CrudRepository<NewPost, Long>{
    List<NewPost> findByDomain(String domain);
}