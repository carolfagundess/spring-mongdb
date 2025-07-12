
package udemy.nelio.spring_mongo.dto;

/**
 *
 * @author carol
 */
public class IngredientDTO {
    
    private String id;
    private String name;
    private Double quantity;

    public IngredientDTO() {
    }

    public IngredientDTO(String id, String name, Double quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    
    
}
