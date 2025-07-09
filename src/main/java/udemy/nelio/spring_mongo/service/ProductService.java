package udemy.nelio.spring_mongo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.spring_mongo.dto.ProductDTO;
import udemy.nelio.spring_mongo.model.Product;
import udemy.nelio.spring_mongo.repository.ProductRepository;
import udemy.nelio.spring_mongo.service.execptions.ObjectNotFoundException;

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

    public Product findById(String id) {
        // Busca o produto. Se não encontrar, lança a exceção informada.
        return prRepostiory.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public Product insert(Product product) {
        return prRepostiory.insert(product);
    }

    public void delete(String id) {
        findById(id); //encontra o objeto primeiro e se nao achar lança exception
        prRepostiory.deleteById(id);
    }

    //caminho inverso :: DTO -> Entity
    public Product fromDTO(ProductDTO dto) {
        return new Product(dto.getId(), dto.getNome(), dto.getDescription(), dto.getPreco());
    }
}
