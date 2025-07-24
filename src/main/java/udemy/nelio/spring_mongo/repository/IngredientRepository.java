
package udemy.nelio.spring_mongo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import udemy.nelio.spring_mongo.model.Ingredient;

/**
 *
 * @author carol
 */
@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String>{
    
    List<Ingredient> findByNameContainingIgnoreCase(String text);
    
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Ingredient> findByName(String text);
}
        