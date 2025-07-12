
package udemy.nelio.spring_mongo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import udemy.nelio.spring_mongo.model.Event;

/**
 *
 * @author carol
 */
public class EventDTO implements Serializable{
    
    private String id;
    private String title; // Ex: "Especial de Páscoa 2026"
    private String themeDescription;
    private LocalDate startDate;
    private LocalDate endDate;

    public EventDTO() {
    }

    public EventDTO(Event eventEntity) {
        this.id = eventEntity.getId();
        this.title = eventEntity.getTitle();
        this.themeDescription = eventEntity.getThemeDescription();
        this.startDate = eventEntity.getStartDate();
        this.endDate = eventEntity.getEndDate();
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

    public String getThemeDescription() {
        return themeDescription;
    }

    public void setThemeDescription(String themeDescription) {
        this.themeDescription = themeDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final EventDTO other = (EventDTO) obj;
        return Objects.equals(this.id, other.id);
    }      
}
