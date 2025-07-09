package udemy.nelio.spring_mongo.service.execptions;

/**
 *
 * @author carol
 */
public class ObjectNotFoundException extends RuntimeException {
    
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
