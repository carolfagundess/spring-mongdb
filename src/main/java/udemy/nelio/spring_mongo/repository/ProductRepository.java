package udemy.nelio.spring_mongo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.spring_mongo.model.Product;

/**
 *
 * @author carol
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByEvent_Id(String eventId);
}
