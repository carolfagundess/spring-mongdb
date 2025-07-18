
package udemy.nelio.spring_mongo.controller.exceptions;

import java.io.Serializable;

/**
 *
 * @author carol
 */
public class StandardError implements Serializable{
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    // Construtor vazio (necessário para serialização)
    public StandardError() {
    }

    // Construtor com todos os campos para facilitar a instanciação
    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters e Setters
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
