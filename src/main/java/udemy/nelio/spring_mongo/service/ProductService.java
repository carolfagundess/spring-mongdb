package udemy.nelio.spring_mongo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.spring_mongo.dto.ProductDTO;
import udemy.nelio.spring_mongo.model.Event;
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
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        // Busca o produto. Se não encontrar, lança a exceção informada.
        return productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public Product insert(Product product) {
        return productRepository.insert(product);
    }

    public void delete(String id) {
        findById(id); //encontra o objeto primeiro e se nao achar lança exception
        productRepository.deleteById(id);
    }

    //A linha findById(obj.getId()) usa o ID do objeto recebido para fazer uma busca no banco de dados. Ela procura pelo produto que já existe na base com aquele ID.
    public Product update(Product obj) {
        Product existingProduct = findById(obj.getId());
        updateData(existingProduct, obj);
        return productRepository.save(existingProduct);
    }

    public Event findEventByProductId(String productId) {
        // 1. Primeiro, buscamos o produto pelo ID. 
        //    O método findById que você já tem cuidará do caso de o produto não existir.
        Product product = findById(productId);
        // 2. Verificamos se o produto realmente tem um evento associado.
        if (product.getEvent() == null) {
            throw new ObjectNotFoundException("O produto com ID: " + productId + " não está associado a nenhum evento.");
        }
        // 3. Retornamos o objeto de evento.
        //    É neste momento que o `lazy = true` do @DBRef entra em ação! 
        //    O Spring Data fará a busca no banco de dados para carregar os dados completos
        //    do SeasonalEvent somente agora, quando ele é de fato acessado.
        return product.getEvent();
    }

    //METODOS AUXILIARES
    //caminho inverso :: DTO -> Entity
    public Product fromDTO(ProductDTO dto) {
        return new Product(dto.getId(), dto.getNome(), dto.getDescription(), dto.getPreco(), dto.getCategory());
    }

    public void updateData(Product newObj, Product obj) {
        newObj.setNome(obj.getNome());
        newObj.setDescription(obj.getDescription());
        newObj.setPreco(obj.getPreco());
        newObj.setCategory(obj.getCategory());
    }
}
