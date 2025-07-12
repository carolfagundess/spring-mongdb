
package udemy.nelio.spring_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.nelio.spring_mongo.dto.EventDTO;
import udemy.nelio.spring_mongo.model.Event;
import udemy.nelio.spring_mongo.service.EventService;

/**
 *
 * @author carol
 */
@RestController
@RequestMapping(value = "/events")
public class EventController {
    
    @Autowired
    private EventService serviceEvent;
    
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> findById(@PathVariable String id) {
        Event event = serviceEvent.findById(id);
        //convertendo o objeto em objetos DTO
        EventDTO eventDTO = new EventDTO(event);
        return ResponseEntity.ok().body(eventDTO);
    }
}
