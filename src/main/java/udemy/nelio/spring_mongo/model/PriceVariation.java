
package udemy.nelio.spring_mongo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author carol
 */
@Document
public class PriceVariation {
    
    @Id
    String id;
    String description;
    BigDecimal price;
    LocalDate date;
    private Product product;

    public PriceVariation() {
    }

    public PriceVariation(String id, String description, BigDecimal price, LocalDate date, Product product) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.date = date;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final PriceVariation other = (PriceVariation) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
