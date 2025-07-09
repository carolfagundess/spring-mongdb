
package udemy.nelio.spring_mongo.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import udemy.nelio.spring_mongo.model.Product;
import udemy.nelio.spring_mongo.repository.ProductRepository;

/**
 *
 * @author carol
 *
 * classe de configuração, inserção de dados no banco de dados
*/
@Configuration
public class Instantiation implements CommandLineRunner{
    
    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        
        repository.deleteAll();
        
        Product p1 = new Product("prod_001", "Bolo Red Velvet", "Bolo aveludado vermelho com recheio e cobertura cremosa de cream cheese frosting. Fatias generosas.", 89.90);
        Product p2 = new Product("prod_002", "Torta de Limão com Merengue", "Massa crocante, recheio de creme de limão siciliano azedinho e uma cobertura de merengue suíço tostado.", 75.00);
        Product p3 = new Product("prod_003", "Caixa de Macarons Sortidos (12 unidades)", "Doze macarons frescos e coloridos nos sabores: pistache, framboesa, chocolate belga e baunilha.", 65.50);
        Product p4 = new Product("prod_004", "Cheesecake de Frutas Vermelhas", "Cheesecake cremoso sobre base de biscoito, coberto com uma calda artesanal de morangos, amoras e mirtilos.", 95.00);
        Product p5 = new Product("prod_005", "Éclair de Chocolate (Bomba)", "Massa choux leve e aerada, recheada com creme de confeiteiro de chocolate meio amargo e coberta com fondant de chocolate.", 18.90);
    
        repository.saveAll(Arrays.asList(p1, p2, p3, p4 , p5));
    }
    
}
