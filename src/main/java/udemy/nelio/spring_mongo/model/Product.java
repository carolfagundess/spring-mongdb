package udemy.nelio.spring_mongo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import udemy.nelio.spring_mongo.dto.CategoryMinDTO;

/**
 *
 * @author carol
 */
@Document(collection = "product")
public class Product implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private Double preco;
    //aninhamentos
    private CategoryMinDTO category;
    //objetos por referencia
    @DBRef
    private Event event;
    @DBRef
    private List<Ingredient> ingredients = new ArrayList<>();

    public Product() {
    }
    
    // CONSTRUTOR PRINCIPAL (completo)
    public Product(String id, String name, String description, Double preco, CategoryMinDTO category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.preco = preco;
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public CategoryMinDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryMinDTO categoryMinDTO) {
        this.category = categoryMinDTO;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    public void setName(String nome) {
        this.name = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Product other = (Product) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", nome=" + name + ", description=" + description + ", preco=" + preco + '}';
    }

}
