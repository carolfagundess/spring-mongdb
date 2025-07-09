package udemy.nelio.spring_mongo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.spring_mongo.model.Product;
import udemy.nelio.spring_mongo.repository.ProductRepository;

/**
 *
 * @author carol
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository prRepostiory;

    public List<Product> findAll() {
        return prRepostiory.findAll();
    }
}
