
package udemy.nelio.spring_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import udemy.nelio.spring_mongo.model.Ingredient;

/**
 *
 * @author carol
 */
public interface IngredientRepository extends MongoRepository<Ingredient, String>{
    
}
