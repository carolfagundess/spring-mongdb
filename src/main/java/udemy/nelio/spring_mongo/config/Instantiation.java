package udemy.nelio.spring_mongo.config;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import udemy.nelio.spring_mongo.model.PriceVariation;
import udemy.nelio.spring_mongo.model.Product;
import udemy.nelio.spring_mongo.repository.PriceVariationRepository;
import udemy.nelio.spring_mongo.repository.ProductRepository;

/**
 *
 * @author carol
 *
 * classe de configuração, inserção de dados no banco de dados
 */
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ProductRepository repositoryProduct;
    @Autowired
    private PriceVariationRepository repositoryPriceV;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repositoryProduct.deleteAll();
        repositoryPriceV.deleteAll();

        Product p1 = new Product(null, "Bolo Red Velvet", "Bolo aveludado vermelho com recheio e cobertura cremosa de cream cheese frosting. Fatias generosas.", 89.90);
        Product p2 = new Product(null, "Torta de Limão com Merengue", "Massa crocante, recheio de creme de limão siciliano azedinho e uma cobertura de merengue suíço tostado.", 75.00);
        Product p3 = new Product(null, "Caixa de Macarons Sortidos (12 unidades)", "Doze macarons frescos e coloridos nos sabores: pistache, framboesa, chocolate belga e baunilha.", 65.50);
        Product p4 = new Product(null, "Cheesecake de Frutas Vermelhas", "Cheesecake cremoso sobre base de biscoito, coberto com uma calda artesanal de morangos, amoras e mirtilos.", 95.00);
        Product p5 = new Product(null, "Éclair de Chocolate (Bomba)", "Massa choux leve e aerada, recheada com creme de confeiteiro de chocolate meio amargo e coberta com fondant de chocolate.", 18.90);

        repositoryProduct.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        PriceVariation pv1p1 = new PriceVariation(null, "Promoção de Lançamento", new BigDecimal("85.00"), LocalDate.of(2025, 5, 10), p1);
        PriceVariation pv2p1 = new PriceVariation(null, "Preço Padrão", new BigDecimal("89.90"), LocalDate.of(2025, 6, 1), p1);

        PriceVariation pv1p2 = new PriceVariation(null, "Preço de Verão", new BigDecimal("72.50"), LocalDate.of(2025, 1, 15), p2);
        PriceVariation pv2p2 = new PriceVariation(null, "Preço Padrão", new BigDecimal("75.00"), LocalDate.of(2025, 3, 1), p2);
        PriceVariation pv3p2 = new PriceVariation(null, "Aumento de Custo de Ingrediente", new BigDecimal("78.00"), LocalDate.of(2025, 7, 1), p2);

        PriceVariation pv1p3 = new PriceVariation(null, "Preço Padrão", new BigDecimal("65.50"), LocalDate.of(2025, 2, 20), p3);

        repositoryPriceV.saveAll(Arrays.asList(pv1p1, pv1p2, pv1p3, pv2p1, pv2p2, pv3p2));
    }

}
