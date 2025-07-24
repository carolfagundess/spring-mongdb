package udemy.nelio.spring_mongo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import udemy.nelio.spring_mongo.controller.util.URL;
import udemy.nelio.spring_mongo.model.Ingredient;
import udemy.nelio.spring_mongo.service.IngredientService;

/**
 *
 * @author carol
 */
@RestController
@RequestMapping(value = "/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService serviceIngredient;
    
    @GetMapping("/titlesearch")
    public ResponseEntity<List<Ingredient>> findById(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Ingredient> ingredients = serviceIngredient.findByName(text);
        return ResponseEntity.ok().body(ingredients);
    }
}
