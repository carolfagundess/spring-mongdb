package udemy.nelio.spring_mongo.dto;

import java.io.Serializable;
import java.util.Objects;
import udemy.nelio.spring_mongo.model.Product;

/**
 *
 * @author carol
 */
public class ProductDTO implements Serializable {
    
    private String id;
    private String nome;
    private String description;
    private Double preco;
    private CategoryMinDTO category; // <-- NOVO CAMPO ADICIONADO

    public ProductDTO() {
    }
    
    public ProductDTO(Product productEntity) {
        this.id = productEntity.getId();
        this.nome = productEntity.getName();
        this.description = productEntity.getDescription();
        this.preco = productEntity.getPreco();
        
        this.category = productEntity.getCategory();
    }

    public CategoryMinDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryMinDTO category) {
        this.category = category;
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
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final ProductDTO other = (ProductDTO) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
