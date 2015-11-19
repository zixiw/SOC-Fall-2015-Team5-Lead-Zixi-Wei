package models;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mingyangling on 11/16/15.
 */
@Named
@Singleton
public interface AWorkflowRepository extends CrudRepository<AWorkflow, Long> {
    List<AWorkflow> findAllByDescription(String description);
    AWorkflow findFirstByName(String name);

}
