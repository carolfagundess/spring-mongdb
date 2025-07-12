package udemy.nelio.spring_mongo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import udemy.nelio.spring_mongo.dto.EventDTO;
import udemy.nelio.spring_mongo.dto.ProductDTO;
import udemy.nelio.spring_mongo.model.Event;
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
    private ProductService serviceProduct ;

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> list = serviceProduct .findAll();
        //convertendo os objetos da lista em objetos DTOs
        List<ProductDTO> listDTO = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String id) {
        Product product = serviceProduct .findById(id);
        //convertendo o objeto em objetos DTO
        ProductDTO productDTO = new ProductDTO(product);
        return ResponseEntity.ok().body(productDTO);
    }
    
    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody ProductDTO dto){
        Product product = serviceProduct .fromDTO(dto);
        product = serviceProduct .insert(product);
        // Constrói a URI a partir da requisição ATUAL, preservando o "/products"
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") // Adiciona o ID ao final da URL atual
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ProductDTO dto, @PathVariable String id) {
        Product productFromRequest  = serviceProduct .fromDTO(dto);
        productFromRequest .setId(id);
        productFromRequest  = serviceProduct .update(productFromRequest);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable String id) {
        serviceProduct.delete(id);
        return ResponseEntity.noContent().build();
    }
    
        // --- NOVO ENDPOINT ---
    @GetMapping(value = "/{id}/events")
    public ResponseEntity<EventDTO> findEventFromProduct(@PathVariable String id) {
        // 1. Chama o serviço para obter a ENTIDADE do evento
        Event eventEntity = serviceProduct.findEventByProductId(id);
        // 2. Converte a ENTIDADE para um DTO antes de retornar na resposta
        EventDTO eventDTO = new EventDTO(eventEntity);
        // 3. Retorna o DTO com o status HTTP 200 OK
        return ResponseEntity.ok().body(eventDTO);
    }
}
