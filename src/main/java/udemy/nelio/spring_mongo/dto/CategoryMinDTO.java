
package udemy.nelio.spring_mongo.dto;

import java.io.Serializable;
import udemy.nelio.spring_mongo.model.Category;

/**
 *
 * @author carol
 */
public class CategoryMinDTO implements Serializable{
    
    private String id;
    private String name;

    public CategoryMinDTO() {
    }

    public CategoryMinDTO(Category category) {
        id = category.getId();
        name = category.getNome();
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
