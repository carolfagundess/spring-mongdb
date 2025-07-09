package udemy.nelio.spring_mongo.dto;

import java.io.Serializable;
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

    public ProductDTO() {
    }

    public ProductDTO(Product productEntity) {
        this.id = productEntity.getId();
        this.nome = productEntity.getNome();
        this.description = productEntity.getDescription();
        this.preco = productEntity.getPreco();
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

}
