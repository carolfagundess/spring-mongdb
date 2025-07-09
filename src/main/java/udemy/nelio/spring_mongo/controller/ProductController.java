package udemy.nelio.spring_mongo.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.nelio.spring_mongo.dto.ProductDTO;
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
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> list = prService.findAll();
        //convertendo os objetos da lista em objetos DTOs
        List<ProductDTO> listDTO = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
