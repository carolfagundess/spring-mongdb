package udemy.nelio.spring_mongo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
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

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String id) {
        Product product = prService.findById(id);
        //convertendo o objeto em objetos DTO
        ProductDTO productDTO = new ProductDTO(product);
        return ResponseEntity.ok().body(productDTO);
    }
    
    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody ProductDTO dto){
        Product product = prService.fromDTO(dto);
        product = prService.insert(product);
        // Constrói a URI a partir da requisição ATUAL, preservando o "/products"
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") // Adiciona o ID ao final da URL atual
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
