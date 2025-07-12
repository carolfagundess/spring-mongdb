
package udemy.nelio.spring_mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.spring_mongo.model.Event;
import udemy.nelio.spring_mongo.repository.EventRepository;
import udemy.nelio.spring_mongo.service.execptions.ObjectNotFoundException;

/**
 *
 * @author carol
 */
@Service
public class EventService {
    
    @Autowired
    EventRepository repository;
    
    public Event findById(String id) {
        // Busca o produto. Se não encontrar, lança a exceção informada.
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }
}
