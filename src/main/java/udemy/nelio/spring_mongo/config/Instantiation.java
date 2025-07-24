package udemy.nelio.spring_mongo.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import udemy.nelio.spring_mongo.dto.CategoryMinDTO;
import udemy.nelio.spring_mongo.model.Category;
import udemy.nelio.spring_mongo.model.PriceVariation;
import udemy.nelio.spring_mongo.model.Product;
import udemy.nelio.spring_mongo.model.Event;
import udemy.nelio.spring_mongo.model.Ingredient;
import udemy.nelio.spring_mongo.repository.CategoryRepository;
import udemy.nelio.spring_mongo.repository.PriceVariationRepository;
import udemy.nelio.spring_mongo.repository.ProductRepository;
import udemy.nelio.spring_mongo.repository.EventRepository;
import udemy.nelio.spring_mongo.repository.IngredientRepository;

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
    @Autowired
    private CategoryRepository repositoryCategory;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {

        repositoryProduct.deleteAll();
        repositoryPriceV.deleteAll();
        repositoryCategory.deleteAll();
        eventRepository.deleteAll();
        ingredientRepository.deleteAll();

        Event veraoEvent = new Event(null, "Especial de Verão 2026",
                "Celebre com nossos doces gelados!", LocalDate.of(2026, 3, 20), LocalDate.of(2026, 4, 5));
        eventRepository.save(veraoEvent);

        // Ingredientes especiais
        // Ingredientes Específicos
        Ingredient ingredient1 = new Ingredient(null, "Extrato de Baunilha de Madagascar"); // Usado em várias receitas
        Ingredient ingredient2 = new Ingredient(null, "Limão Siciliano"); // Para a Torta de Limão
        Ingredient ingredient3 = new Ingredient(null, "Pistache Iraniano"); // Para os Macarons
        Ingredient ingredient4 = new Ingredient(null, "Frutas Vermelhas Frescas"); // Para o Cheesecake

        List<Ingredient> ingredientsToSave = Arrays.asList(ingredient4, ingredient3, ingredient2, ingredient1);

        Category category1 = new Category(null, "Bolos", "Bolos fofos e recheados para todas as ocasiões.");
        Category category2 = new Category(null, "Tortas", "Tortas doces com massas crocantes e recheios cremosos.");
        Category category3 = new Category(null, "Macarons e Doces Finos", "Pequenas delícias coloridas e sofisticadas.");
        Category category4 = new Category(null, "Sobremesas Geladas", "Cheesecakes, mousses e outras delícias para refrescar.");
        Category category5 = new Category(null, "Pâtisserie Clássica", "Doces tradicionais da confeitaria francesa, como éclairs e mil-folhas.");

        repositoryCategory.saveAll(Arrays.asList(category1, category2, category3, category4, category5));
        ingredientRepository.saveAll(ingredientsToSave);

        Product p1 = new Product(null, "Bolo Red Velvet",
                "Bolo aveludado vermelho com recheio e cobertura cremosa de cream cheese frosting. Fatias generosas.",
                89.90, new CategoryMinDTO(category1));
        Product p2 = new Product(null, "Torta de Limão com Merengue",
                "Massa crocante, recheio de creme de limão siciliano azedinho e uma cobertura de merengue suíço tostado.",
                75.00, new CategoryMinDTO(category2));
        Product p3 = new Product(null, "Caixa de Macarons Sortidos (12 unidades)",
                "Doze macarons frescos e coloridos nos sabores: pistache, framboesa, chocolate belga e baunilha.",
                65.50, new CategoryMinDTO(category3));
        Product p4 = new Product(null, "Cheesecake de Frutas Vermelhas",
                "Cheesecake cremoso sobre base de biscoito, coberto com uma calda artesanal de morangos, amoras e mirtilos.",
                95.00, new CategoryMinDTO(category4));
        Product p5 = new Product(null, "Éclair de Chocolate (Bomba)",
                "Massa choux leve e aerada, recheada com creme de confeiteiro de chocolate meio amargo e coberta com fondant de chocolate.",
                18.90, new CategoryMinDTO(category5));

        p1.setEvent(veraoEvent);
        p1.getIngredients().add(ingredient1);
        p2.getIngredients().add(ingredient2);
        p3.getIngredients().add(ingredient3);
        p4.getIngredients().add(ingredient4);
        p5.getIngredients().add(ingredient1);
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
