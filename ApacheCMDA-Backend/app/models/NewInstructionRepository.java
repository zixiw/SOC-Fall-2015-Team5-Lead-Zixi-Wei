package models;

import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by zixiwei on 11/30/15.
 */
@Named
@Singleton
public interface NewInstructionRepository extends CrudRepository<NewInstruction, Long>{}
