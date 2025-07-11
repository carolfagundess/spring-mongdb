
package udemy.nelio.spring_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.spring_mongo.model.PriceVariation;

/**
 *
 * @author carol
 */
@Repository
public interface PriceVariationRepository extends MongoRepository<PriceVariation, Integer>{
    
}
