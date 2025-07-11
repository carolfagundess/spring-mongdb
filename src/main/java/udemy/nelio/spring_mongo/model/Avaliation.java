
package udemy.nelio.spring_mongo.model;

import java.io.Serializable;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author carol
 */
@Document
public class Avaliation implements Serializable{
    
    @Id
    Integer Id;
    Integer nota;
    String Comentario;
    String nome;
    LocalDate date;

    public Avaliation() {
    }

    public Avaliation(Integer nota, String Comentario, String nome, LocalDate date) {
        this.nota = nota;
        this.Comentario = Comentario;
        this.nome = nome;
        this.date = date;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
