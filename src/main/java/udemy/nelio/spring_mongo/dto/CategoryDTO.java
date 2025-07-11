package udemy.nelio.spring_mongo.dto;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import udemy.nelio.spring_mongo.model.Category;

/**
 *
 * @author carol
 */
public class CategoryDTO implements Serializable {

    @Id
    String id;
    String nome;
    String description;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        id = category.getId();
        nome = category.getNome();
        description = category.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoryDTO other = (CategoryDTO) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
