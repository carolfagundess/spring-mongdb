package udemy.nelio.spring_mongo.model;

import java.io.Serializable;
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
    private String nome;
    private String description;
    private Double preco;
    
    private CategoryMinDTO category;
    
    @DBRef
    private Event event;

    public Product() {
    }
    
    // CONSTRUTOR PRINCIPAL (completo)
    public Product(String id, String nome, String description, Double preco, CategoryMinDTO category, Event event) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.preco = preco;
        this.category = category;
        this.event = event;
    }

    // --- NOVO CONSTRUTOR PARA PRODUTOS NORMAIS (sem evento) ---
    public Product(String id, String nome, String description, Double preco, CategoryMinDTO category) {
        // 'this(...)' chama o construtor principal, passando 'null' para o campo opcional.
        // Isso evita a repetição de código.
        this(id, nome, description, preco, category, null);
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
        return "Product{" + "id=" + id + ", nome=" + nome + ", description=" + description + ", preco=" + preco + '}';
    }

}
