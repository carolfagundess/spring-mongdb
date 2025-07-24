
package udemy.nelio.spring_mongo.dto;

import udemy.nelio.spring_mongo.model.Ingredient;

/**
 *
 * @author carol
 */
public class IngredientDTO {
    
    private String id;
    private String name;

    public IngredientDTO() {
    }

    public IngredientDTO(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
