package udemy.nelio.spring_mongo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.nelio.spring_mongo.model.Product;

/**
 *
 * @author carol
 */
@RestController
@RequestMapping(value = "/products")
public class ProductController {

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        Product product = new Product("1", "teste", "teste", 2.5);
        List<Product> list = new ArrayList<>();
        list.add(product);
        return ResponseEntity.ok().body(list);
    }
}
