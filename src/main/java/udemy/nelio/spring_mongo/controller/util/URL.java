
package udemy.nelio.spring_mongo.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carol
 */
public class URL {
    
    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(URL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
