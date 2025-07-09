package udemy.nelio.spring_mongo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.nelio.spring_mongo.model.Product;
import udemy.nelio.spring_mongo.service.ProductService;

/**
 *
 * @author carol
 */
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService prService;
    
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = prService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
