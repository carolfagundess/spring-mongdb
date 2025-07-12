
package udemy.nelio.spring_mongo.dto;

import java.util.Objects;
import udemy.nelio.spring_mongo.model.Event;

/**
 *
 * @author carol
 */
public class EventMinDTO {
    private String id;
    private String title;

    public EventMinDTO() {
    }

    public EventMinDTO(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EventMinDTO other = (EventMinDTO) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
