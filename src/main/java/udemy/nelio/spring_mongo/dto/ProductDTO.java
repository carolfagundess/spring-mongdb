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
    private EventMinDTO event;

    public ProductDTO() {
    }
    
    public ProductDTO(Product productEntity) {
        this.id = productEntity.getId();
        this.nome = productEntity.getNome();
        this.description = productEntity.getDescription();
        this.preco = productEntity.getPreco();
        
        this.category = productEntity.getCategory();
        // Só tente criar o EventMinDTO se o evento existir no produto.
        if (productEntity.getEvent() != null) {
            this.event = new EventMinDTO(productEntity.getEvent());
        }
        // Se for nulo, o campo 'event' do DTO permanecerá nulo, o que está correto.
    }

    public CategoryMinDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryMinDTO category) {
        this.category = category;
    }

    public EventMinDTO getEvent() {
        return event;
    }

    public void setEvent(EventMinDTO event) {
        this.event = event;
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
