package udemy.nelio.spring_mongo.model;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import udemy.nelio.spring_mongo.dto.CategoryMinDTO;

/**
 *
 * @author carol
 */
@Document
public class Product implements Serializable {

    @Id
    private String id;
    private String nome;
    private String description;
    private Double preco;
    private CategoryMinDTO categoryMinDTO;

    public Product() {
    }

    //sobrecarga provisoria
    public Product(String id, String nome, String description, Double preco) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.preco = preco;
    }

    public Product(String id, String nome, String description, Double preco, CategoryMinDTO categoryMinDTO) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.preco = preco;
        this.categoryMinDTO = categoryMinDTO;
    }

    public CategoryMinDTO getCategory() {
        return categoryMinDTO;
    }

    public void setCategory(CategoryMinDTO categoryMinDTO) {
        this.categoryMinDTO = categoryMinDTO;
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
