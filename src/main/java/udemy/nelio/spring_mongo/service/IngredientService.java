package udemy.nelio.spring_mongo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.spring_mongo.model.Ingredient;
import udemy.nelio.spring_mongo.repository.IngredientRepository;

/**
 *
 * @author carol
 */
@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> findByName(String text) {
        return ingredientRepository.findByNameContainingIgnoreCase(text);
    }
}
