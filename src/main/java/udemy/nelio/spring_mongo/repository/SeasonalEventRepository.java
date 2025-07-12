package udemy.nelio.spring_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.spring_mongo.model.Event;

/**
 *
 * @author carol
 */
@Repository
public interface SeasonalEventRepository extends MongoRepository<Event, String> {

}
